package com.example.andrewmoney.data.repository

import com.example.andrewmoney.data.remote.service.RemoteService

class AppRepository (private val remoteService: RemoteService) {
    suspend fun test(){
        val test = remoteService.getLatestVaults()
        println(test)
    }

}