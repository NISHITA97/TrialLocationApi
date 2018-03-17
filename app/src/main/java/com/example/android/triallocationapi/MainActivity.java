package com.example.android.triallocationapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.android.triallocationapi.Adapter.DistrictAdapter;
import com.example.android.triallocationapi.Model.District;
import com.example.android.triallocationapi.Model.JsonRead;
import com.example.android.triallocationapi.Model.Records;
import com.example.android.triallocationapi.Service.RetroFitInstance;
import com.example.android.triallocationapi.Service.getDistrictDataService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    // url that should be called:  https://api.data.gov.in/resource/6176ee09-3d56-4a3b-8115-21841576b2f6?format=json&api-key=579b464db66ec23bdd000001d9a35f1fb0e8498d708826968ea6b64e&filters[pincode]=110085
    private DistrictAdapter adapter;
    private RecyclerView recyclerView;
    private String apiKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiKey="579b464db66ec23bdd000001d9a35f1fb0e8498d708826968ea6b64e";
        /*Create handle for the RetrofitInstance interface*/
        getDistrictDataService service = RetroFitInstance.getRetrofitInstance().create(getDistrictDataService.class);

        /*Call the method with parameter in the interface */
        Call<JsonRead> call = service.getLocationList("json",apiKey,"110085");
        Log.wtf("URL Called", call.request().url() + "");
        call.enqueue(new Callback<JsonRead>() {
            @Override
            public void onResponse(Call<JsonRead> call, Response<JsonRead> response) {
                Log.wtf("on response", response.body().toString());
                generateDistrictList(response.body().getRecords());
            }
            @Override
            public void onFailure(Call<JsonRead> call, Throwable t) {
                Log.wtf("on response Failure",t.toString());
                Toast.makeText(MainActivity.this, "Something went wrong.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateDistrictList(ArrayList<Records> records) {
        recyclerView =  findViewById(R.id.recycler_view_district_list);
        ArrayList<District> districtList = new ArrayList<>();
        for(Records record : records)
        {
            District curr = new District();
            curr.setPincode(record.getPincode());
            curr.setDistrict(record.getDistrictname());
            districtList.add(curr);
        }

        adapter = new DistrictAdapter(districtList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
    }
}
