package com.me.lordmathi2741.bnha.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CharacterDao{
    @Query("SELECT * FROM favorite_characters")
    fun getAll(): List<FavoriteCharacter>
    @Query("SELECT * FROM favorite_characters WHERE id = :id")
    fun getById(id: Int): FavoriteCharacter?
    @Insert
    fun insert(character: FavoriteCharacter)
    @Delete
    fun delete(character: FavoriteCharacter)
}