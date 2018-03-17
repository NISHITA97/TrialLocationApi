package com.example.android.triallocationapi.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Nishita Aggarwal on 18-03-2018.
 */

public class JsonRead {

    @SerializedName("created")
    String created;
    @SerializedName("updated")
    Integer updated;
    @SerializedName("title")
    String title;
    @SerializedName("desc")
    String desc;
    @SerializedName("source")
    String source;

    @SerializedName("org_type")
    String org_type;
    @SerializedName("org")
    ArrayList<String> org;
    @SerializedName("sector")
    ArrayList<String> sector;

    @SerializedName("visualizable")
    String visualizable;
    @SerializedName("index_name")
    String index_name;
    @SerializedName("catalog_uuid")
    String catalog_uuid;
    @SerializedName("status")
    String status;
    @SerializedName("message")
    String message;
    @SerializedName("total")
    Integer total;
    @SerializedName("count")
    Integer count;
    @SerializedName("limit")
    Integer limit;
    @SerializedName("offset")
    Integer offset;

    @SerializedName("fields")
    ArrayList<Fields> fields;

    @SerializedName("records")
    ArrayList<Records> records;

    @SerializedName("version")
    String version;


    public ArrayList<Records> getRecords() {
        return records;
    }

}
