package com.example.android.triallocationapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.android.triallocationapi.Adapter.DistrictAdapter;
import com.example.android.triallocationapi.Model.District;
import com.example.android.triallocationapi.Service.RetroFitInstance;
import com.example.android.triallocationapi.Service.getDistrictDataService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

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
        Call<String> call = service.getLocationList("json",apiKey,"110085");
        Log.wtf("URL Called", call.request().url() + "");
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.wtf("onresponse", response.body().toString());
                //generateDistrictList(response.body().getDistrictArrayList());
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.wtf("onresponseFailiure",t.toString());
                Toast.makeText(MainActivity.this, "Something went wrong.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateDistrictList(ArrayList<District> districtList) {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_district_list);

        adapter = new DistrictAdapter(districtList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
    }
}
