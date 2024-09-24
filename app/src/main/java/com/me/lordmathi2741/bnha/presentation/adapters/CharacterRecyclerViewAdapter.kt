package com.me.lordmathi2741.bnha.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.me.lordmathi2741.bnha.R
import com.me.lordmathi2741.bnha.data.local.AppDataBase
import com.me.lordmathi2741.bnha.data.local.FavoriteCharacter
import com.me.lordmathi2741.bnha.domain.models.Character
import com.me.lordmathi2741.bnha.presentation.prototypes.CharacterPrototype

class CharacterRecyclerViewAdapter(private val characters : List<Character>) : RecyclerView.Adapter<CharacterPrototype>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterPrototype {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.character_card, parent, false)
        return CharacterPrototype(layout)
    }

    override fun onBindViewHolder(holder: CharacterPrototype, position: Int) {
        holder.bind(characters[position])
        val favoriteButton = holder.itemView.findViewById<ImageButton>(R.id.ibtnFavorite)
        favoriteButton.setOnClickListener {
            val favoriteCharacterDao = AppDataBase.getInstance(holder.itemView.context).characterDao()
            val favoriteCharacter = FavoriteCharacter(
                id = null,
                name = characters[position].name,
                nameJapanese = characters[position].nameJapanese,
                quirk = characters[position].quirk,
                quirkJapanese = characters[position].quirkJapanese,
                quirkDescription = characters[position].quirkDescription,
                heroSchool = characters[position].heroSchool,
                classHero = characters[position].classHero,
            )
            favoriteCharacterDao.insert(favoriteCharacter)

            Toast.makeText(holder.itemView.context, "Character added to favorites", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return characters.size
    }
}