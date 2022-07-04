package com.example.andrewmoney

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.andrewmoney.databinding.ActivityMainBinding
import com.example.andrewmoney.databinding.FragmentVaultBinding
import com.example.andrewmoney.ui.history.History
import com.example.andrewmoney.ui.vault.Vault
import com.example.andrewmoney.viewmodel.AppViewModel
import com.example.andrewmoney.viewmodel.AppViewModelFactory

class MainActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: AppViewModel
    private val vaultFragment = Vault()
    private val historyFragment = History()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        initViewModel()


        binding.navigation.setOnNavigationItemSelectedListener{
            when (it.itemId) {
                R.id.home -> replaceFragment(vaultFragment)
                R.id.history -> replaceFragment(historyFragment)

            }
            true
        }
        setContentView(binding.root)
    }

    private fun initViewModel(){
        val repository = (application as MainApplication).repository
        mainViewModel = ViewModelProvider(this,
            AppViewModelFactory.VaultViewModelFactory(repository)
        ).get(AppViewModel::class.java)
    }
    private fun replaceFragment(fragment: Fragment){
        if (fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(binding.fragmentContainer.id, fragment)
            transaction.commit()
        }

    }

}