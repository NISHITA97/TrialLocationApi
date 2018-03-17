package com.example.android.triallocationapi.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Nishita Aggarwal on 18-03-2018.
 */

public class Records {
    @SerializedName("officename")
    String officename;
    @SerializedName("pincode")
    String pincode;
    @SerializedName("officetype")
    String officetype;
    @SerializedName("deliverystatus")
    String deliverystatus;
    @SerializedName("divisionname")
    String divisionname;
    @SerializedName("regionname")
    String regionname;
    @SerializedName("circelname")
    String circlename;
    @SerializedName("taluk")
    String taluk;
    @SerializedName("districtname")
    String districtname;
    @SerializedName("statename")
    String statename ;

    public String getPincode() {
        return pincode;
    }

    public String getDistrictname() {
        return districtname;
    }
}
