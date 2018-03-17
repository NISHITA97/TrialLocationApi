package com.example.android.triallocationapi.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Nishita Aggarwal on 15-03-2018.
 */

public class DistrictList {
    @SerializedName("records")
    ArrayList<District> districtArrayList;

    public ArrayList<District> getDistrictArrayList() {
        return districtArrayList;
    }

    public void setDistrictArrayList(ArrayList<District> districtArrayList) {
        this.districtArrayList = districtArrayList;
    }
}
