package com.satyamthakur.bio_guardian.data.api

import com.satyamthakur.bio_guardian.data.entity.AnimalInfoResponse
import com.satyamthakur.bio_guardian.data.entity.AnimalPredictionResponse
import com.satyamthakur.bio_guardian.data.entity.MistralRequest
import com.satyamthakur.bio_guardian.data.entity.MistralResponse
import retrofit2.Response;
import retrofit2.http.Body
import retrofit2.http.GET;
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface NinjaApiService {
    @GET("animals")
    suspend fun getAnimalInfo(
        @Query("name") animalName: String,
        @Header("x-api-key") xApiKey: String = "API_KEY_HERE"
    ): Response<AnimalInfoResponse>
}

interface ImagePredictionApiService {
    @GET("2")
    suspend fun getAnimalPrediction(
        @Query("api_key") apiKey: String = "API_KEY_HERE",
        @Query("image") imageUrl: String = "https://www.istockphoto.com/photo/song-sparrow-perched-on-a-wood-gm1368317578-438329228"
    ): Response<AnimalPredictionResponse>
}

interface MistralImageRecognitionApi {
    @Headers(
        "Content-Type: application/json",
        "Authorization: Bearer API"
    )
    @POST("v1/chat/completions")
    suspend fun getChatCompletion(@Body request: MistralRequest): Response<MistralResponse>
}