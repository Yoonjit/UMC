package com.example.week7_1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.example.week7_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val imagelist : ArrayList<Int> = arrayListOf(
//            R.drawable.jd_1,
//            R.drawable.jd_2,
//            R.drawable.jd_3,
//            R.drawable.jd_4,
//            R.drawable.jd_5,
//        )
//
//        var index = 0
//        val handler = Handler(mainLooper)
//
//
//        Thread(){
//            while (true){
//                if(index == imagelist.size-1){
//                    index = 0
//                }
//                else{
//                    index++
//                }
//
//                // handler.post -> 여기서 하기 힘드니까 핸들러가 있는 스레드(UI Thread)에서 해줘~
//                handler.post {
//                    binding.ivImage.setImageResource(imagelist[index])
//                }
//
//                Thread.sleep(2000)
//            }
//        }.start()

        val sharedPrefs = getSharedPreferences("sharedpref", Context.MODE_PRIVATE)
        val editor = sharedPrefs.edit()

        editor.putString("Jiki", "") // 이 코드는 무시 - 초기화 용도
        editor.apply() // 이 코드는 무시 - 초기화 용도

        editor.putString("Jiki", "android")
        val beforeapplyvalue = sharedPrefs.getString("Jiki", "")
        Log.d("SP before", "${beforeapplyvalue}")

        editor.apply()

        val spvalue = sharedPrefs.getString("Jiki", "")
        Log.d("SP", "${spvalue}")

    }
}