package com.islas.codechallengenov.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.islas.codechallengenov.databinding.ListItemBinding
import com.islas.codechallengenov.domain.models.Character

class HomeAdapter(private val characterList: List<Character>) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    private lateinit var mBinding: ListItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        mBinding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(mBinding.root)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val data = characterList[position]
        with(mBinding){
            characterTitle.text = data.name
            characterDescription.text = data.description
        }
    }

    override fun getItemCount(): Int = characterList.size

    inner class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view)
}