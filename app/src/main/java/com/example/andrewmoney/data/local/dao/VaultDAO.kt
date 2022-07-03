package com.example.andrewmoney.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.andrewmoney.data.local.model.LocalVaultModel

@Dao
interface VaultDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  pushAllVaults(vaults: List<LocalVaultModel>)
    @Query("SELECT * FROM vault")
    suspend fun getVoults(): List<LocalVaultModel>
    @Query("UPDATE vault SET rate = :rate WHERE name = :name")
    suspend fun uodateVault(name: String, rate: Double);
    @Query("UPDATE vault SET isLiked = :isLiked WHERE name = :name")
    suspend fun likeVault(name: String, isLiked: Boolean)
}
