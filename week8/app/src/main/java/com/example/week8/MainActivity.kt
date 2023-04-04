package com.example.week8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.week8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        val roomDb = AppDatabase.getInstance(this)

        if(roomDb != null){
//            val user = User("지키", 23) // 생성
//            roomDb.userDao().insert(user)

//            roomDb.userDao().updateNameByUserId(1, "지키키키키키") // 변경

//            val deletedUser = User("", 100, 1) // 삭제
//            roomDb.userDao().delete(deletedUser)

            val userList = roomDb.userDao().selectAll() // 모든 유저 정보 확인
            Log.d("DB", "User List : ${userList}")

//            val user1 = roomDb.userDao().selectByUserId(1)
//            Log.d("DB", "User Id 1 : ${user1}")

        }
    }
}