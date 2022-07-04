package com.example.andrewmoney.data.repository

import android.content.Context
import android.net.Network
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.andrewmoney.data.local.LocalDataSource
import com.example.andrewmoney.data.local.model.LocalVaultModel
import com.example.andrewmoney.data.remote.service.RemoteService
import com.example.andrewmoney.data.utils.NetworkUtil

class AppRepository (private val remoteService: RemoteService, private val localService: LocalDataSource, private val context: Context) {
    private val vaultsLiveData = MutableLiveData<List<LocalVaultModel>>()
    val vaults: LiveData<List<LocalVaultModel>>
        get() = vaultsLiveData

    suspend fun getLatestVaults() {
        if (NetworkUtil.isInternetAvailable(context)) {
            val vaultsRemote = remoteService.getLatestVaults()
            val vaultsLocal = localService.vaultDAO().getVaults()
            val _wait = runCatching { vaultsRemote }
            _wait.onSuccess {
                val remoteRates: Map<String, Double> = it.rates
                if (vaultsLocal.isEmpty()) {
                    val localVaults: MutableList<LocalVaultModel> = mutableListOf()
                    remoteRates.forEach { rate ->
                        localVaults.add(LocalVaultModel(0, rate.key, rate.value, false))
                    }

                    vaultsLiveData.postValue(localVaults)
                    localService.vaultDAO().pushAllVaults(localVaults)

                }
                else{
                    remoteRates.forEach{ rate ->
                    localService.vaultDAO().updateVault(rate.key, rate.value)
                    }
                }
            }
        }

    }
    suspend fun likeVault(name: String){
        localService.vaultDAO().updateIsLiked(name, true)
    }
    suspend fun dislikeVault(name: String){
        localService.vaultDAO().updateIsLiked(name, false)
    }
}

