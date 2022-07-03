package com.example.andrewmoney

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.andrewmoney.databinding.ActivityMainBinding
import com.example.andrewmoney.viewmodel.AppViewModel
import com.example.andrewmoney.viewmodel.AppViewModelFactory

class MainActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: AppViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val repository = (application as MainApplication).repository
        mainViewModel = ViewModelProvider(this,
            AppViewModelFactory.VaultViewModelFactory(repository)
        ).get(AppViewModel::class.java)
        setContentView(binding.root)
    }

}