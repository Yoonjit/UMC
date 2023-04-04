package com.example.week8_1.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(MemoEntity::class), version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getMemoDao(): MemoDao

    companion object{
        val databaseName = "db_memo"
        var appDatabase: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase?{
            if (appDatabase == null){
                appDatabase = Room.databaseBuilder(context,
                    AppDatabase::class.java,
                    databaseName).build()
            }
            return appDatabase
        }
    }
}