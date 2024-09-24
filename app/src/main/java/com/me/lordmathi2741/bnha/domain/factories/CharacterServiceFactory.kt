package com.me.lordmathi2741.bnha.domain.factories

import com.me.lordmathi2741.bnha.data.remote.CharacterService
import com.me.lordmathi2741.bnha.shared.Constants

class CharacterServiceFactory {
    suspend fun createCharacterServiceInstance(): CharacterService{
        return retrofit2.Retrofit.
            Builder().
            baseUrl(Constants.BASE_URL)
            .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
            .build().create(CharacterService::class.java)
    }
}