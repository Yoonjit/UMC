package com.example.week5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var userRecyclerViewAdapter: UserRecyclerViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRecyclerView()
    }

    private fun setUpRecyclerView(){
        binding.userRecyclerView.apply {
            userRecyclerViewAdapter = UserRecyclerViewAdapter()
            adapter = userRecyclerViewAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        addItem()
    }

    private fun addItem(){
        userRecyclerViewAdapter?.addUserItems(User("냥", "1"))
        userRecyclerViewAdapter?.addUserItems(User("냥냥", "2"))
        userRecyclerViewAdapter?.addUserItems(User("냥냥냥", "3"))
        userRecyclerViewAdapter?.addUserItems(User("냥냥냥냥", "4"))
        userRecyclerViewAdapter?.addUserItems(User("냥냥냥냥냥", "5"))
        userRecyclerViewAdapter?.addUserItems(User("냥냥냥냥냥냥", "6"))
        userRecyclerViewAdapter?.addUserItems(User("냥냥냥냥냥냥냥", "7"))
        userRecyclerViewAdapter?.addUserItems(User("냥냥냥냥냥냥냥냥", "8"))
        userRecyclerViewAdapter?.addUserItems(User("냥냥냥냥냥냥냥냥냥", "9"))
        userRecyclerViewAdapter?.addUserItems(User("냥냥냥냥냥냥냥냥냥냥", "10"))
        userRecyclerViewAdapter?.addUserItems(User("냥냥냥냥냥냥냥냥냥냥냥", "11"))
        userRecyclerViewAdapter?.addUserItems(User("냥냥냥냥냥냥냥냥냥냥냥냥", "12"))
        userRecyclerViewAdapter?.addUserItems(User("냥냥냥냥냥냥냥냥냥냥냥냥냥", "13"))
        userRecyclerViewAdapter?.addUserItems(User("냥냥냥냥냥냥냥냥냥냥냥냥냥냥", "14"))
        userRecyclerViewAdapter?.addUserItems(User("냥냥냥냥냥냥냥냥냥냥냥냥냥냥냥", "15"))
    }

}