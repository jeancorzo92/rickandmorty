package com.jeancorzo.rickandmorty.characters.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.jeancorzo.rickandmorty.characters.domain.model.Character
import com.jeancorzo.rickandmorty.databinding.ItemCharacterBinding

class CharacterListPagingAdapter(
    private val onCharacterClickListener: CharacterClickListener = CharacterClickListener {}
) : PagingDataAdapter<Character, CharacterListPagingAdapter.CharacterViewHolder>(CharacterComparator) {

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding =
            ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding)
    }

    inner class CharacterViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(character: Character) {
            binding.character = character
            binding.characterItemClick = onCharacterClickListener
            binding.executePendingBindings()
        }
    }

}

fun interface CharacterClickListener {
    fun onCharacterClicked(character: Character)
}

object CharacterComparator : DiffUtil.ItemCallback<Character>() {
    override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem == newItem
    }

}