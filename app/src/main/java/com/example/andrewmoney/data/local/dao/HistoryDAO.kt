package com.example.andrewmoney.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.andrewmoney.data.local.model.LocalHistoryModel
import com.example.andrewmoney.data.local.model.LocalVaultModel

@Dao
interface HistoryDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  pushAllHistory(history: List<LocalHistoryModel>)
    @Query("SELECT * FROM history")
    suspend fun getHistory(): List<LocalHistoryModel>
}