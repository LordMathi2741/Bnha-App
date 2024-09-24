package com.me.lordmathi2741.bnha.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "favorite_characters",
)
class FavoriteCharacter(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "nameJapanese")
    val nameJapanese: String,
    @ColumnInfo(name = "quirk")
    val quirk: String,
    @ColumnInfo(name = "quirkJapanese")
    val quirkJapanese: String,
    @ColumnInfo(name = "quirkDescription")
    val quirkDescription: String,
    @ColumnInfo(name = "heroSchool")
    val heroSchool: String,
    @ColumnInfo(name = "classHero")
    val classHero: String,

)