package com.example.week4

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.week4.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.txtSecond.text = intent.getStringExtra("data")

        binding.btnSecond.setOnClickListener {
            val builder = AlertDialog.Builder(this)

            builder.setTitle("메모")
            builder.setMessage("수정할 거임?")

            builder.setPositiveButton("ㅇㅇ") { dialog, which ->
                var intent2 = Intent(this, ThirdActivity::class.java)
                startActivity(intent2)
            }
            builder.setNegativeButton("ㄴㄴ") { dialog, which ->
            }
            builder.setOnCancelListener {
            }

            builder.show()
        }

        Log.d("Lifecycle", "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("Lifecycle", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Lifecycle", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Lifecycle", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Lifecycle", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Lifecycle", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Lifecycle", "onDestroy")
    }
}