package com.example.week3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.week3.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityMainBinding.inflate(layoutInflater) // inflate(): xml 파일을 읽어서 해석하겠다

        setContentView(viewBinding.root)
//        // R: 앱 전체를 관리하는 파일
//        // root = activity_main.xml의 내용

        Log.d("Lifecycle", "onCreate")

        viewBinding.button.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
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

//
//
//        supportFragmentManager
//            .beginTransaction()
//            .replace(viewBinding.frameFragment.id, FirstFragment())
//            .commitAllowingStateLoss()
//
//        viewBinding.btnFragment1.setOnClickListener{
//            supportFragmentManager
//                .beginTransaction()
//                .replace(viewBinding.frameFragment.id, FirstFragment())
//                .commitAllowingStateLoss()
//        }
//
//        viewBinding.btnFragment2.setOnClickListener{
//            supportFragmentManager
//                .beginTransaction()
//                .replace(viewBinding.frameFragment.id, SecondFragment())
//                .commitAllowingStateLoss()
//        }

//        viewBinding.tvText.text = "안녕"
//        // 이거 주석처리하면 원래대로 123 나옴

//        viewBinding.button.setOnClickListener{ // 클릭 이벤트가 일어났을 때 무엇을 할지 설정
//            val intent = Intent(this, SecondActivity::class.java) // 인텐트를 빈 객체로 만들 수도 있음 (괄호에 아무것도 안 쓰기)
//
//            // 인텐트에 정보 담기 (전송)
//            intent.putExtra("text", "first")
//
//            startActivity(intent)

