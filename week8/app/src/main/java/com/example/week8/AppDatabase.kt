package com.example.week8

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version=1)
abstract class AppDatabase: RoomDatabase() { // 깊게 이해 ㄴㄴ, 알고 싶으면 싱글턴 패턴 찾아보기
    abstract fun userDao(): UserDao

    companion object{
        private var appDatabase: AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppDatabase?{
            if(appDatabase == null){
                synchronized(AppDatabase::class.java){
                    appDatabase = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "app-database"
                    ).allowMainThreadQueries().build()
                }
            }
            return appDatabase
        }
    }
}