package com.example.android.triallocationapi.Service;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Nishita Aggarwal on 15-03-2018.
 */

public class RetroFitInstance {
        private static Retrofit retrofit;
        static String url2="https://api.data.gov.in/resource/";
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
