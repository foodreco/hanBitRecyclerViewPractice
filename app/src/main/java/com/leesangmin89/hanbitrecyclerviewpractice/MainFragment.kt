package com.leesangmin89.hanbitrecyclerviewpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.leesangmin89.hanbitrecyclerviewpractice.databinding.ActivityMainBinding
import com.leesangmin89.hanbitrecyclerviewpractice.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private val binding by lazy { FragmentMainBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //1. 리싸이클러에 들어갈 데이터
        val data = loadData()

        //2. 어뎁터 설정
        val adapter = ReAdapter()

        //3. 리싸이클러뷰와 연결
        binding.recyclerViewPractice.adapter = adapter

        //4. 리싸이클러뷰에 데이터 전달
        adapter.setData(data)

        binding.buttonOn.setOnClickListener {
            it.findNavController().navigate(MainFragmentDirections.actionMainFragmentToBFragment())
        }
        return binding.root
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