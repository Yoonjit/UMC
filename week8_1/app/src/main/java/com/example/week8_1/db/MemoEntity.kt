package com.example.week8_1.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MemoEntity(
    @PrimaryKey(autoGenerate = true) var id: Int? = null,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "star") var star: Int
)