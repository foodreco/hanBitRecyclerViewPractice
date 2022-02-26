package com.leesangmin89.hanbitrecyclerviewpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.leesangmin89.hanbitrecyclerviewpractice.databinding.ActivityMainBinding

data class ReData(
    var reTitle: Int,
    var reContents: String,
    var reDuration: String,
    var isExpanded: Boolean = false
)

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //1. 리싸이클러에 들어갈 데이터
        val data = loadData()

        //2. 어뎁터 설정
        val adapter = ReAdapter()

        //3. 리싸이클러뷰와 연결
        binding.recyclerViewPractice.adapter = adapter

        //4. 리싸이클러뷰에 데이터 전달
        adapter.setData(data)

        binding.buttonOn.setOnClickListener {

        }
    }

    private fun loadData(): MutableList<ReData> {
        val sampleList = mutableListOf<ReData>()
        for (no in 1..25) {
            val dataContents = "연습 내용 #$no"
            val dataDuration = "연습 시간 $no"
            val data = ReData(no, dataContents, dataDuration, false)
            sampleList.add(data)
        }
        return sampleList
    }
}