package com.example.android.triallocationapi.Model;

/**
 * Created by Nishita Aggarwal on 15-03-2018.
 */
import com.google.gson.annotations.SerializedName;
public class District {
    @SerializedName("pincode")
    String pincode;

    @SerializedName("districtname")
    String district;

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
