package com.me.lordmathi2741.bnha.presentation.prototypes

import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.me.lordmathi2741.bnha.R
import com.me.lordmathi2741.bnha.data.local.AppDataBase
import com.me.lordmathi2741.bnha.data.local.FavoriteCharacter

class FavoriteCharacterPrototype(view: View) : RecyclerView.ViewHolder(view) {
    val tvFavoriteCharacter = view.findViewById<TextView>(R.id.tvFavoriteCharacter)
    val ivFavoriteCharacter = view.findViewById<ImageView>(R.id.ivFavoriteCharacter)
    val tvJFavoriteJapaneseName = view.findViewById<TextView>(R.id.tvJFavoriteJapaneseName)
    val tvFavoriteQuirk = view.findViewById<TextView>(R.id.tvFavoriteQuirk)
    val tvFavoriteQuirkJapanese = view.findViewById<TextView>(R.id.tvFavoriteQuirkJapanese)
    val tvFavoriteQuirkDescription = view.findViewById<TextView>(R.id.tvFavoriteQuirkDescription)
    val tvFavoriteHeroSchool = view.findViewById<TextView>(R.id.tvFavoriteHeroSchool)
    val tvFavoriteHeroClass = view.findViewById<TextView>(R.id.tvFavoriteHeroClass)
    fun bind(character: FavoriteCharacter) {
        tvFavoriteCharacter.text = character.name
        tvJFavoriteJapaneseName.text = character.nameJapanese
        tvFavoriteQuirk.text = character.quirk
        tvFavoriteQuirkJapanese.text = character.quirkJapanese
        tvFavoriteQuirkDescription.text = character.quirkDescription
        tvFavoriteHeroSchool.text = character.heroSchool
        tvFavoriteHeroClass.text = character.classHero
        Glide.with(ivFavoriteCharacter.context).load("https://tse4.mm.bing.net/th?id=OIP.5-H_EqTLCOFwyugg4-eWXwHaEK&pid=Api&P=0&h=180").into(ivFavoriteCharacter)
    }
}