package com.islas.codechallengenov.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.islas.codechallengenov.domain.models.Character

object  CharacterComparator : DiffUtil.ItemCallback<Character>() {
    override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem == newItem
    }
}
