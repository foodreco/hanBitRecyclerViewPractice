package com.leesangmin89.hanbitrecyclerviewpractice

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.leesangmin89.hanbitrecyclerviewpractice.databinding.ActivityMainBinding
import com.leesangmin89.hanbitrecyclerviewpractice.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private val binding by lazy { FragmentMainBinding.inflate(layoutInflater) }

    //2. 어뎁터 설정
    private val adapter by lazy { ReAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //1. 리싸이클러에 들어갈 데이터
        val data = loadData()


        //3. 리싸이클러뷰와 연결
        binding.recyclerViewPractice.adapter = adapter

        //4. 리싸이클러뷰에 데이터 전달
        adapter.setData(data)

        binding.buttonOn.setOnClickListener {
            it.findNavController().navigate(MainFragmentDirections.actionMainFragmentToBFragment())
        }

        binding.buttonOff.setOnClickListener {
            val list = adapter.getTestList()
            Log.i("확인","list : $list")
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

    override fun onDestroyView() {
        super.onDestroyView()
        val list = adapter.getTestList()
        Log.i("확인","list : $list")
        adapter.clearTestList()
        Log.i("확인","list clearTestList : $list")
        Log.i("확인","MainFragment onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("확인","MainFragment onDestroy")
    }
}