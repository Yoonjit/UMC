package com.example.week5

import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.week5.databinding.ItemDataBinding

class UserRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private val userItems = arrayListOf<User>()
    private val userCheckBoxStatus = arrayListOf<UserCheckStatus>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder
            = UserItemViewHolder(ItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is UserItemViewHolder)
            holder.bind(userItems[position], userCheckBoxStatus[position])
    }

    override fun getItemCount(): Int = if (userItems.isNullOrEmpty()) 0 else userItems.size

    fun addUserItems(user: User){
        userItems.add(user)
        userCheckBoxStatus.add(UserCheckStatus(userItems.size - 1, false))
        notifyItemInserted(userItems.size-1)
    }

    inner class UserItemViewHolder(private val binding: ItemDataBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(userItem: User, userStatus: UserCheckStatus) = with(binding){
            tvUserId.text = userItem.userId
            tvUserName.text = userItem.userName

            checkboxUser.isChecked = userStatus.isChecked

            checkboxUser.setOnClickListener {
                userStatus.isChecked = checkboxUser.isChecked
                notifyItemChanged(adapterPosition)
            }
        }
    }
}