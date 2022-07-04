package com.example.andrewmoney.ui.vault.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.andrewmoney.data.local.model.LocalVaultModel
import com.example.andrewmoney.databinding.VaultItemBinding

class VaultAdapter: RecyclerView.Adapter<VaultAdapter.VaultViewHolder>() {
    var vaultList: List<LocalVaultModel> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VaultViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = VaultItemBinding.inflate(inflater, parent, false)
        return VaultViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VaultViewHolder, position: Int) {
        val item = vaultList[position]
        with(holder.binding){
            vaultName.text = item.name
        }
    }

    override fun getItemCount(): Int {
        return vaultList.size
    }
    class VaultViewHolder (var binding: VaultItemBinding): RecyclerView.ViewHolder(binding.root)


}