package com.me.lordmathi2741.bnha.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(FavoriteCharacter::class), version = 3)
abstract class AppDataBase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
    companion object {
       private var INSTANCE : AppDataBase? = null
        fun getInstance(context : Context) : AppDataBase{
            if(INSTANCE == null){
                INSTANCE = Room
                    .databaseBuilder(context, AppDataBase::class.java, "bnha-database")
                    .fallbackToDestructiveMigration().
                allowMainThreadQueries()
                    .build()
            }
            return INSTANCE as AppDataBase
        }
    }

}