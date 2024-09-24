package com.me.lordmathi2741.bnha.domain.models

import com.google.gson.annotations.SerializedName

data class CharacterWrapper(
    @SerializedName("students")
    val characters : List<Character>
)