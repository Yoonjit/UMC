package com.example.week3_hw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week3_hw.databinding.ActivitySecondBinding
import com.example.week3_hw.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(viewBinding.frameFragment.id, FirstFragment())
            .commitAllowingStateLoss()

        viewBinding.btnFragment1.setOnClickListener{
            supportFragmentManager
                .beginTransaction()
                .replace(viewBinding.frameFragment.id, FirstFragment())
                .commitAllowingStateLoss()
        }

        viewBinding.btnFragment2.setOnClickListener{
            supportFragmentManager
                .beginTransaction()
                .replace(viewBinding.frameFragment.id, SecondFragment())
                .commitAllowingStateLoss()
        }
    }
}