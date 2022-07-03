package com.example.andrewmoney.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.andrewmoney.data.local.model.LocalHistoryModel
import com.example.andrewmoney.data.local.model.LocalVaultModel

@Dao
interface HistoryDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  pushAllHistory(history: List<LocalHistoryModel>)
}