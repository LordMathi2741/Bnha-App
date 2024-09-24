package com.me.lordmathi2741.bnha.domain.models

import com.google.gson.annotations.SerializedName

data class Character (
    @SerializedName("name")
    val name: String,
    @SerializedName("name_japanese")
    val nameJapanese: String,
    @SerializedName("other_names")
    val otherNames: List<String>,
    @SerializedName("quirk")
    val quirk: String,
    @SerializedName("quirk_japanese")
    val quirkJapanese: String,
    @SerializedName("quirk_description")
    val quirkDescription: String,
    @SerializedName("hero_school")
    val heroSchool: String,
    @SerializedName("class")
    val classHero: String,

)