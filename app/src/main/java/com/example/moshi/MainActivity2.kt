package com.example.moshi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moshi.databinding.ActivityMain2Binding
import retrofit2.Call
import retrofit2.Response

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding;

    private lateinit var main2Adapter : Main2Adapter;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater);
        setContentView(binding.root);

        main2Adapter = Main2Adapter();

        binding.rv.apply {
          setHasFixedSize(true);
            layoutManager = LinearLayoutManager(this@MainActivity2);
            adapter = main2Adapter;
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
        };
    }

    private fun retrofitWork() {
        val service = RetrofitInstance.retrofitService

        service.getStoreData(RetrofitInstance.API_KEY,"json")
            .enqueue(object : retrofit2.Callback<Api> {
                override fun onResponse(call: Call<Api>, response: Response<Api>) {
                    val result = response.body()?.GGEXPSDLV?.get(1)?.row;
                    main2Adapter.submitList(result!!);
                };

                override fun onFailure(call: Call<Api>, t: Throwable) {
                    Log.d("태그",t.message.toString());
                };
            });
    };
}

