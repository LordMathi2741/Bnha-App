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
import com.me.lordmathi2741.bnha.domain.models.Character

class CharacterPrototype(view: View) : RecyclerView.ViewHolder(view) {
    val tvName = view.findViewById<TextView>(R.id.tvName)
    val tvQuirk = view.findViewById<TextView>(R.id.tvQuirk)
    val tvHeroSchool = view.findViewById<TextView>(R.id.tvHeroSchool)
    val tvNameJapanese = view.findViewById<TextView>(R.id.tbNameJapanese)
    val tvOtherNames = view.findViewById<TextView>(R.id.tvOtherNames)
    val tvQuirkJapanese = view.findViewById<TextView>(R.id.tvQuirkJapanese)
    val tvQuirkSchool = view.findViewById<TextView>(R.id.tvQuirkDescription)
    val tvHeroClass = view.findViewById<TextView>(R.id.tvHeroClass)
    val ivCharacter = view.findViewById<ImageView>(R.id.ivCharacter)

    fun bind(character: Character) {
        tvName.text = character.name
        tvQuirk.text = character.quirk
        tvHeroSchool.text = character.heroSchool
        tvNameJapanese.text = character.nameJapanese
        tvOtherNames.text = character.otherNames.joinToString(", ")
        tvQuirkJapanese.text = character.quirkJapanese
        tvQuirkSchool.text = character.quirkDescription
        tvHeroClass.text = character.classHero
        Glide.with(ivCharacter.context).load("https://tse4.mm.bing.net/th?id=OIP.5-H_EqTLCOFwyugg4-eWXwHaEK&pid=Api&P=0&h=180").into(ivCharacter)


    }

}