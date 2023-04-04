package com.example.week3_hw

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.week3_hw.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.button.setOnClickListener{ // 클릭 이벤트가 일어났을 때 무엇을 할지 설정
            val intent = Intent(this, SecondActivity::class.java) // 인텐트를 빈 객체로 만들 수도 있음 (괄호에 아무것도 안 쓰기)

            // 인텐트에 정보 담기 (전송)
            intent.putExtra("text", viewBinding.edittext.text.toString())
            startActivity(intent)
        }
    }


}