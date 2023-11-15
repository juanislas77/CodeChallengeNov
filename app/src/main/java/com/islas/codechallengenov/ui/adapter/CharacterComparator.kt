package com.islas.codechallengenov.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.islas.codechallengenov.domain.models.Character

object  CharacterComparator : DiffUtil.ItemCallback<Character>() {
    override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem.id == newItem.id //&& oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem.name == newItem.name
    }
}
