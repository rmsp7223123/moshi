package com.example.moshi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moshi.databinding.ActivityMain3Binding
import org.json.JSONObject
import org.json.JSONTokener

class MainActivity3 : AppCompatActivity() {

    private lateinit var binding : ActivityMain3Binding;
    private lateinit var mAdapter : Main3Adapter;
    private lateinit var horizonManager: LinearLayoutManager;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain3Binding.inflate(layoutInflater);
        setContentView(binding.root);

        val json = assets.open("test.json").reader().readText();
        val data = JSONObject(json).getJSONObject("data");

        mAdapter = Main3Adapter(data);
        horizonManager = LinearLayoutManager(this@MainActivity3);
        horizonManager.orientation = LinearLayoutManager.HORIZONTAL;

        binding.recyclerStore.apply {
            layoutManager = horizonManager
            adapter = mAdapter;
        };

    };
}