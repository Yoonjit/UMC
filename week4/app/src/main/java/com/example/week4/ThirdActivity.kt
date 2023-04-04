package com.example.week4

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.week4.databinding.ActivityMainBinding
import com.example.week4.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityThirdBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        binding.btnThird.setOnClickListener {
            var intent3 = Intent(this, SecondActivity::class.java)
            intent3.putExtra("data", binding.edtThird.text.toString())
            startActivity(intent3)
        }
    }
}