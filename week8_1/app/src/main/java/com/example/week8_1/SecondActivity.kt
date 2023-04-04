package com.example.week8_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.week8_1.databinding.ActivitySecondBinding
import com.example.week8_1.db.AppDatabase
import com.example.week8_1.db.MemoDao
import com.example.week8_1.db.MemoEntity

class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding
    lateinit var db: AppDatabase
    lateinit var memoDao: MemoDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = AppDatabase.getInstance(this)!!
        memoDao = db.getMemoDao()

        binding.save.setOnClickListener {
            insertMemo()
        }
    }

    private fun insertMemo(){
        val memoTitle = binding.editTitle.text.toString() // 메모 내용
        var memoStar = binding.radioGroup.checkedRadioButtonId // 즐겨찾기

        when(memoStar){
            R.id.btn_yes -> {
                memoStar = 1
            }
            R.id.btn_no -> {
                memoStar = 0
            }
            else -> {
                memoStar = -1
            }
        }

        if (memoStar == -1 || memoTitle.isBlank()){
            Toast.makeText(this, "모든 항목 채워야 함", Toast.LENGTH_SHORT).show()
        }
        else{
            Thread{
                memoDao.insertMemo(MemoEntity(null, memoTitle, memoStar))
                runOnUiThread{
                    Toast.makeText(this, "메모 추가 완료", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }.start()
        }
    }
}