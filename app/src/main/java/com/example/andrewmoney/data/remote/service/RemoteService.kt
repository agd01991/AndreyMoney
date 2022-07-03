package com.example.andrewmoney.data.remote.service

import com.example.andrewmoney.data.local.model.VaultModel
import retrofit2.http.GET

interface RemoteService {
    @GET("latest.js")
    suspend fun getLatestVaults(): VaultModel
}