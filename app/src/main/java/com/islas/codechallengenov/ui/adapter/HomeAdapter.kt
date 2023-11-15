package com.islas.codechallengenov.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.islas.codechallengenov.R
import com.islas.codechallengenov.databinding.ListItemBinding
import com.islas.codechallengenov.domain.models.Character
import com.squareup.picasso.Picasso

class HomeAdapter:
    PagingDataAdapter<Character, HomeAdapter.CharacterViewHolder>(CharacterComparator) {

    private lateinit var mBinding: ListItemBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        mBinding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(mBinding.root)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        getItem(position)?.let { data ->
            holder.setIsRecyclable(false)
            with(mBinding) {
                tvName.text = data.name
                tvDescription.text = data.description
                Picasso.get().load(data.image).error(R.drawable.marvel_logo).into(imgPhoto)
            }
        }
    }

    inner class CharacterViewHolder(view: View) : RecyclerView.ViewHolder(view) {}
}
