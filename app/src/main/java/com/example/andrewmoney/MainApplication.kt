package com.example.andrewmoney

import android.app.Application
import com.example.andrewmoney.data.remote.RemoteDataSource
import com.example.andrewmoney.data.remote.service.RemoteService
import com.example.andrewmoney.data.repository.AppRepository


class MainApplication : Application() {
    lateinit var repository: AppRepository
    override fun onCreate() {
        super.onCreate()

        val remoteService = RemoteDataSource.getInstance().create(RemoteService::class.java)
        repository = AppRepository(remoteService, applicationContext)
    }
}