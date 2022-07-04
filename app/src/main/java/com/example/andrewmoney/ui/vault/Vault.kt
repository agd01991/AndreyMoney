package com.example.andrewmoney.ui.vault

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.andrewmoney.MainApplication
import com.example.andrewmoney.R
import com.example.andrewmoney.data.local.model.LocalVaultModel
import com.example.andrewmoney.databinding.FragmentVaultBinding
import com.example.andrewmoney.ui.vault.adapter.VaultAdapter
import com.example.andrewmoney.viewmodel.AppViewModel
import com.example.andrewmoney.viewmodel.AppViewModelFactory
import kotlinx.coroutines.launch

class Vault : Fragment(){
    private lateinit var binding: FragmentVaultBinding
    private lateinit var adapter: VaultAdapter
    private lateinit var mainViewModel: AppViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentVaultBinding.inflate(inflater, container, false)
        initViewModel()
        adapter = VaultAdapter()
        val layoutManager = LinearLayoutManager(context)
        binding.vaultRecycler.layoutManager = layoutManager
        binding.vaultRecycler.adapter = adapter
        updateRecyclerData()
        return binding.root
    }
    private fun initViewModel(){
        val repository = (activity?.application as MainApplication).repository
        mainViewModel = ViewModelProvider(this,
            AppViewModelFactory.VaultViewModelFactory(repository)
        ).get(AppViewModel::class.java)
    }
    private fun updateRecyclerData(){
        lifecycleScope.launch {
            mainViewModel.getLatestVault().observe(viewLifecycleOwner, Observer {
                val _wait = runCatching { it }
                _wait.onSuccess {
                    adapter.vaultList = it
                    adapter.notifyDataSetChanged()

                }
            })


        }
    }
}