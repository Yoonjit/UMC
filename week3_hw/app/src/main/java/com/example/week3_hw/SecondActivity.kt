package com.example.week3_hw

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.week3_hw.databinding.ActivityMainBinding
import com.example.week3_hw.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val extras = intent.extras
        val data = extras!!["text"] as String

        viewBinding.textview.text = data

        viewBinding.buttonMove.setOnClickListener{ // 클릭 이벤트가 일어났을 때 무엇을 할지 설정
            val intent = Intent(this, ThirdActivity::class.java) // 인텐트를 빈 객체로 만들 수도 있음 (괄호에 아무것도 안 쓰기)
            startActivity(intent)
        }
    }
}