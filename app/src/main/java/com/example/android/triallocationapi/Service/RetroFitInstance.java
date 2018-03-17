package com.example.android.triallocationapi.Service;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Nishita Aggarwal on 15-03-2018.
 */

public class RetroFitInstance {
        private static Retrofit retrofit;
        private static final String url1= "http://navjacinth9.000webhostapp.com/json/";
        static String url2="https://api.data.gov.in/resource/";//6176ee09-3d56-4a3b-8115-21841576b2f6";
               // "?format=json&api-key=579b464db66ec23bdd000001d9a35f1fb0e8498d708826968ea6b64e&filters[pincode]=110085";
        public static Retrofit getRetrofitInstance() {
            if (retrofit == null) {
                retrofit = new retrofit2.Retrofit.Builder()
                        .baseUrl(url2)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
            Log.e("url==",retrofit.baseUrl().toString());
            return retrofit;
        }

}
