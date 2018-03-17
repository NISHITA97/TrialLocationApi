package com.example.android.triallocationapi.Service;

import com.example.android.triallocationapi.Model.JsonRead;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Nishita Aggarwal on 15-03-2018.
 */

public interface getDistrictDataService {

        @GET("6176ee09-3d56-4a3b-8115-21841576b2f6")
        Call<JsonRead> getLocationList(@Query("format") String json, @Query("api-key") String apiKey, @Query("filters[pincode]") String pincode);

}