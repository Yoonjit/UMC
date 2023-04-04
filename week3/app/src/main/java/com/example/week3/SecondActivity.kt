package com.example.week3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.week3.databinding.ActivityMainBinding
import com.example.week3.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySecondBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)

//        val extras = intent.extras
//        val data = extras!!["text"] as String // 형변환
//
//        viewBinding.tvSecondtext.text = data

        Log.d("Lifecycle2", "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("Lifecycle2", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Lifecycle2", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Lifecycle2", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Lifecycle2", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Lifecycle2", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Lifecycle2", "onDestroy")
    }
}