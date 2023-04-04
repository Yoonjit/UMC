package com.example.week5

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.week5.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySecondBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)

        viewBinding.txtSecond.text =intent.getStringExtra("data")

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