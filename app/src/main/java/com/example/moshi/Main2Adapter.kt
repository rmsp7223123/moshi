package com.example.moshi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.moshi.databinding.ActivityMain2Binding
import com.example.moshi.databinding.ItemStoreBinding

class Main2Adapter : ListAdapter<Row, Main2Adapter.Main2ViewHolder>(DiffUtilCallback) {

    inner class Main2ViewHolder(private val binding: ItemStoreBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(row: Row) {
            binding.tvName.text = row.STR_NM;    // 매장명
            binding.tvName2.text = row.INDUTYPE_NM;    // 업종
            binding.tvAddress.text = row.REFINE_ROADNM_ADDR;   // 지번주소
            binding.tvLat.text = row.REFINE_WGS84_LAT;    // 위도
            binding.tvLogt.text = row.REFINE_WGS84_LOGT;    // 경도
        };
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Main2ViewHolder {
        val binding = ItemStoreBinding.inflate(LayoutInflater.from(parent.context),parent,false);
        return Main2ViewHolder(binding);
    };

    override fun onBindViewHolder(holder: Main2ViewHolder, position: Int) {
        holder.bind(currentList[position]);
    };


};

object DiffUtilCallback : DiffUtil.ItemCallback<Row>() {
    override fun areItemsTheSame(oldItem: Row, newItem: Row): Boolean {
        return oldItem.hashCode() == newItem.hashCode();
    };

    override fun areContentsTheSame(oldItem: Row, newItem: Row): Boolean {
        return oldItem == newItem;
    };
};