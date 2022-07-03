package com.example.andrewmoney.data.repository

import android.content.Context
import android.net.Network
import com.example.andrewmoney.data.remote.service.RemoteService
import com.example.andrewmoney.data.utils.NetworkUtil

class AppRepository (private val remoteService: RemoteService, private val context: Context) {
    suspend fun getLatestVaults(){
        if (NetworkUtil.isInternetAvailable(context)){
            val vaults = remoteService.getLatestVaults()
            val _wait = runCatching { vaults }
            _wait.onSuccess {
                val rates : Map<String, Double> = it.rates
                println(rates)
            }
        }

    }

}