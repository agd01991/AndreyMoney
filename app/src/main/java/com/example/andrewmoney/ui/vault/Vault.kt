package com.example.andrewmoney.ui.vault

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.andrewmoney.R
import com.example.andrewmoney.databinding.FragmentVaultBinding

class Vault : Fragment(){
    private lateinit var binding: FragmentVaultBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentVaultBinding.inflate(inflater, container, false)
        return binding.root
    }
}