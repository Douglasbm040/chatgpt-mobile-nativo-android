package com.example.estudo.api

import com.example.estudo.api.model.modelchatgpt
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Path

interface endpoint {
    @GET("/gh/fawazahmed0/currency-api@1/latest/currencies.json")
    fun getcurrinces(): Call<JsonObject>

    @Headers( "Content-Type: application/json", "Authorization: Bearer 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")
    @POST("v1/chat/completions")
    fun getrate(@Body requestbody: RequestBody)

    @Headers( "Authorization: Bearer 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")
    @POST("v1/completions") // Substitua pelo endpoint correto do serviço
    suspend fun getcompletions(@Body Data: modelchatgpt): Response<ResponseBody>

}