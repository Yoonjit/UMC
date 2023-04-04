package com.example.week6_hw

import android.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.lifecycle.lifecycleScope
import com.example.week6_hw.databinding.ActivityMainBinding
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay


class MainActivity : AppCompatActivity() {
    lateinit var job : Job
    private var Position = 0

    private val viewBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

//        supportFragmentManager
//            .beginTransaction()
//            .replace(viewBinding.containerFragment.id, HomeFragment())
//            .commitAllowingStateLoss()
//
//        viewBinding.navBottom.run {
//            setOnItemSelectedListener {
//                when (it.itemId) {
//                    R.id.menu_home -> {
//                        supportFragmentManager
//                            .beginTransaction()
//                            .replace(viewBinding.containerFragment.id, HomeFragment())
//                            .commitAllowingStateLoss()
//                    }
//                    R.id.menu_setting -> {
//                        supportFragmentManager
//                            .beginTransaction()
//                            .replace(viewBinding.containerFragment.id, SettingFragment())
//                            .commitAllowingStateLoss()
//                    }
//                    R.id.menu_camera -> {
//                        supportFragmentManager
//                            .beginTransaction()
//                            .replace(viewBinding.containerFragment.id, CameraFragment())
//                            .commitAllowingStateLoss()
//                    }
//                }
//                true
//            }
//            selectedItemId = R.id.menu_home
//        }

        val mainVPAdapter = MainVPAdapter(this)
        viewBinding.viewpager.adapter = mainVPAdapter
        viewBinding.indicator.setViewPager(viewBinding.viewpager)

        viewBinding.indicator.createIndicators(6, 0)
//        viewBinding.indicator.animatePageSelected(0)

        viewBinding.viewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {  //사용자가 스크롤 했을때 position 수정
                super.onPageSelected(position)
                Position = position

            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
                when (state) {
                    ViewPager2.SCROLL_STATE_IDLE -> {
                        if (!job.isActive) scrollJobCreate()
                    }

                    ViewPager2.SCROLL_STATE_DRAGGING -> {
                        job.cancel()
                    }

                    ViewPager2.SCROLL_STATE_SETTLING -> {}
                }
            }

        })


//        val tabTitleArray = arrayOf(
//            "1",
//            "2",
//            "3"
//        )

//        TabLayoutMediator(viewBinding.tabMain, viewBinding.vpMain) {
////            tab, position -> tab.text = tabTitleArray[position]
//            tab, position -> tab.text
//        }.attach()


    }

    fun scrollJobCreate(){
        job = lifecycleScope.launchWhenResumed {
            delay(2000)
            viewBinding.viewpager.setCurrentItem(++Position, true)
        }
    }

    override fun onResume() {
        super.onResume()
        scrollJobCreate()
    }

    override fun onPause() {
        super.onPause()
        job.cancel()
    }

}