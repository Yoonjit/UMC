package com.example.week8

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao // 데이터를 실질적으로 가져오고 생성하고 지우고 조회하고 업데이트하고...
interface UserDao {
    @Insert
    fun insert(user: User)

    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM USER")
    fun selectAll(): List<User>

    @Query("SELECT * FROM USER WHERE userId = :userId")
    fun selectByUserId(userId: Int): User

    @Query("SELECT * FROM USER WHERE name = :name")
    fun selectByUserName(name: String): List<User>

    @Query("UPDATE User SET name = :name WHERE userId = :userId")
    fun updateNameByUserId(userId: Int, name: String)

}