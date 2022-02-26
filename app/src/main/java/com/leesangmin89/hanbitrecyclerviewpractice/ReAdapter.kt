package com.leesangmin89.hanbitrecyclerviewpractice

import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.util.set
import androidx.recyclerview.widget.RecyclerView
import com.leesangmin89.hanbitrecyclerviewpractice.databinding.RecyclerItemLayoutBinding

class ReAdapter() : RecyclerView.Adapter<ReAdapter.Holder>() {

    var list = emptyList<ReData>()
    private val expandStatus = SparseBooleanArray()

    fun setData(list: List<ReData>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class Holder constructor(private val binding: RecyclerItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val reNumber = binding.textTitle
        val reContents = binding.textContents
        val reDuration = binding.textDuration
        val layoutExpand = binding.layoutExpand

        // 리사이클러 터치 변수
        val expand = binding.expandButton


        fun bind(reData: ReData, num: Int) {
            val item = list[num]
            reNumber.text = item.reTitle.toString()
            reContents.text = item.reContents
            reDuration.text = item.reDuration

            // expandable layout 코드
            if (expandStatus[num]) {
                expand.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24)
                layoutExpand.visibility = View.VISIBLE
            } else {
                expand.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24)
                layoutExpand.visibility = View.GONE
            }

            expand.setOnClickListener {
                expandStatus[num] = !expandStatus[num]
                notifyDataSetChanged()
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding =
            RecyclerItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(list[position], position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}