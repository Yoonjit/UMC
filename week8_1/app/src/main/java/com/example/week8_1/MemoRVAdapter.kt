package com.example.week8_1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week8_1.databinding.ActivitySecondBinding
import com.example.week8_1.databinding.ItemMemoBinding
import com.example.week8_1.db.MemoEntity

class MemoRVAdapter(private val memoList: ArrayList<MemoEntity>, private val listener: OnItemLongClickListener): RecyclerView.Adapter<MemoRVAdapter.MyViewHolder>() {
    inner class MyViewHolder(binding: ItemMemoBinding):
            RecyclerView.ViewHolder(binding.root){
                val tv_star = binding.tvStar
                val tv_title = binding.tvTitle
                val root =  binding.root
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding: ItemMemoBinding = ItemMemoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val memoData = memoList[position]

        when(memoData.star){
            1 -> {
                holder.tv_star.setBackgroundResource(R.drawable.star)
            }
            0 -> {
                holder.tv_star.setBackgroundResource(R.color.white)
            }
        }

        holder.tv_title.text = memoData.title
        holder.root.setOnLongClickListener{
            listener.onLongClick(position)
            false
        }
    }

    override fun getItemCount(): Int {
        return memoList.size
    }
}