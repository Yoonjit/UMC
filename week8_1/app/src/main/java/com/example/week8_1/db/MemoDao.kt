package com.example.week8_1.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MemoDao {
    @Query("SELECT * FROM MemoEntity") // 모든 데이터 불러오기
    fun getAll(): List<MemoEntity>

    @Query("SELECT * FROM MemoEntity WHERE star = 1") // 즐겨찾기 불러오기
    fun getStar(): List<MemoEntity>

    @Insert // 생성
    fun insertMemo(memo: MemoEntity)

    @Delete // 삭제
    fun deleteMemo(memo: MemoEntity)
}