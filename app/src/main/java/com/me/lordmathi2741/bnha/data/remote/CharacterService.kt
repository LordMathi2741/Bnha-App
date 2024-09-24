package com.me.lordmathi2741.bnha.data.remote

import com.me.lordmathi2741.bnha.domain.models.CharacterWrapper
import com.me.lordmathi2741.bnha.shared.Constants
import retrofit2.http.GET

interface CharacterService {
    @GET(Constants.RESOURCE_PATH)
    suspend fun getAllCharacters(): CharacterWrapper
}