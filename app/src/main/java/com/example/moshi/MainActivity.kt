package com.example.moshi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moshi.databinding.ActivityMainBinding
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);

        // JSON 데이터
        val json = "{\"name\":\"John Doe\",\"age\":30,\"isDeveloper\":true}"

        // Moshi 인스턴스 생성
        val moshi = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build();

        // Person 클래스와 연결된 JsonAdapter 생성
        val personAdapter: JsonAdapter<Person> = moshi.adapter(Person::class.java);

        // JSON을 Person 객체로 파싱
        val person: Person? = personAdapter.fromJson(json);

        // 파싱된 결과를 출력
        if (person != null) {
            binding.tv1.text = "${person.name}";
            binding.tv2.text = "${person.age}";
            binding.tv3.text = "${person.isDeveloper}";
            println("Name: ${person.name}");
            println("Age: ${person.age}");
            println("Is Developer: ${person.isDeveloper}");
        } else {
            println("JSON 파싱 실패");
        };

        binding.btnMove.setOnClickListener { Intent(this, MainActivity2::class.java); };
    }
}