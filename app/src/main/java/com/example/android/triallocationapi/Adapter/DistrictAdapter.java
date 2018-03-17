package com.example.android.triallocationapi.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.triallocationapi.Model.District;
import com.example.android.triallocationapi.R;

import java.util.ArrayList;

/**
 * Created by Nishita Aggarwal on 15-03-2018.
 */

public class DistrictAdapter extends RecyclerView.Adapter<DistrictAdapter.DistrictViewHolder> {
    private ArrayList<District> dataList;

    public DistrictAdapter(ArrayList<District> dataList) {
        this.dataList = dataList;
    }

    public ArrayList<District> getDataList() {
        return dataList;
    }

    @Override
    public DistrictViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row, parent, false);
        return new DistrictViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DistrictViewHolder holder, int position) {
        holder.district.setText(dataList.get(position).getDistrict());
        holder.pincode.setText(dataList.get(position).getPincode());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class DistrictViewHolder extends RecyclerView.ViewHolder {

        TextView pincode,district;

        DistrictViewHolder(View itemView) {
            super(itemView);
            pincode =  itemView.findViewById(R.id.textView_pincode);
            district = itemView.findViewById(R.id.textView_district);
        }
    }
}
