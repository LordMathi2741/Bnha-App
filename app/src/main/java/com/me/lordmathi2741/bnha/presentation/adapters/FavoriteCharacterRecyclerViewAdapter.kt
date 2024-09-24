package com.me.lordmathi2741.bnha.presentation.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.me.lordmathi2741.bnha.R
import com.me.lordmathi2741.bnha.data.local.AppDataBase
import com.me.lordmathi2741.bnha.data.local.FavoriteCharacter
import com.me.lordmathi2741.bnha.presentation.prototypes.FavoriteCharacterPrototype
import com.me.lordmathi2741.bnha.presentation.ui.CharactersInfoActivity

class FavoriteCharacterRecyclerViewAdapter(private val favoriteCharacters: List<FavoriteCharacter>) : RecyclerView.Adapter<FavoriteCharacterPrototype>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteCharacterPrototype {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.favorite_character_card, parent, false)
        return FavoriteCharacterPrototype(layout)
    }

    override fun onBindViewHolder(holder: FavoriteCharacterPrototype, position: Int) {
        holder.bind(favoriteCharacters[position])
        val deleteButton = holder.itemView.findViewById<ImageButton>(R.id.ibtnDelete)
        deleteButton.setOnClickListener {
            val favoriteCharacterDao = AppDataBase.getInstance(holder.itemView.context).characterDao()
            val intent = Intent(holder.itemView.context, CharactersInfoActivity::class.java)
            favoriteCharacterDao.delete(favoriteCharacters[position])
            Toast.makeText(holder.itemView.context, "Character deleted to favorites", Toast.LENGTH_SHORT).show()
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return favoriteCharacters.size
    }
}