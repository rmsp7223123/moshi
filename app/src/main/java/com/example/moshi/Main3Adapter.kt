package com.example.moshi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moshi.databinding.ActivityMain2Binding
import com.example.moshi.databinding.ItemStore2Binding
import com.example.moshi.databinding.ItemStoreBinding
import org.json.JSONArray
import org.json.JSONObject

class Main3Adapter(private val datas: JSONObject) :
    RecyclerView.Adapter<Main3Adapter.CustomViewHolder>() {
    private val listStore = datas.getJSONArray("store_list")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return CustomViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_store2, parent, false)
        );
    };

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bind(listStore);
    };

    override fun getItemCount(): Int {
        return listStore.length();
    };

    class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvStoreNm: TextView = view.findViewById(R.id.store_name);
        val tvStoreImg: ImageView = view.findViewById(R.id.img_url);

        fun bind(listStore: JSONArray) {
            val iObj = listStore.getJSONObject("$position".toInt());
            val name = iObj.getString("store_name");
            var imgUrl = iObj.getString("image_url");

            tvStoreNm.text = name
            Glide.with(itemView)
                .load("http:"+ imgUrl)
                .circleCrop()
                .into(tvStoreImg);
        };
    };
};