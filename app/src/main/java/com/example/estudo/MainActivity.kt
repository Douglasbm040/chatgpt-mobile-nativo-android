package com.example.estudo

import HttpUtil
import android.content.res.Configuration
import android.net.Network
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.estudo.api.endpoint
import com.example.estudo.api.model.modelchatgpt
import com.google.gson.JsonObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Objects
import kotlin.concurrent.thread

class MainActivity : ComponentActivity() {
    private val textFieldViewModel = TextFieldViewModel()
    private val chatViewModel = ChatViewModel()
    private val htta = HttpUtil.apiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            ChatComponent(textFieldViewModel, chatViewModel)
            chatViewModel.re("oi")
        }
    }



    fun getClient(): endpoint {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openai.com/v1/chat/completions")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(endpoint::class.java)
    }
    // Função suspensa para fazer a chamada de API
    suspend fun getCUR(json: String): String = withContext(Dispatchers.IO) {
        val URL = "https://reqres.in/"
        val client = OkHttpClient()
        val headhttp = MediaType.parse("application/json")
        val bod = RequestBody.create(headhttp, json)
        val request = Request.Builder()
            .url(URL)
            .post(bod)
            //.addHeader("Authorization", "Bearer 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")
            .build()
        val response = client.newCall(request).execute()
        return@withContext response.code().toString() ?: ""  //response.body()?.string() ?: ""
    }
 suspend fun getCURR(json:String) = coroutineScope {
        val URL = "https://api.openai.com/v1/chat/completions"
        val headhttp = MediaType.parse("application/json")//MediaType.parse("Bearer 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")
        val client = OkHttpClient()
        val bod = RequestBody.create(headhttp,json)
        val request = Request.Builder().url(URL).post(bod).addHeader("Content-Type", "application/json")
            .addHeader("Authorization", "Bearer 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").build()
        val response = client.newCall(request).execute()
        val a = response.body().toString()

        /*
        val client = OkHttpClient()
        val mediaType = MediaType.parse("application/json")
        val body = RequestBody.create(mediaType, "{\n    \"model\": \"gpt-3.5-turbo\",\n    \"messages\": [{\"role\": \"user\", \"content\": \"Hello!\"}]\n  }")
        val request = Request.Builder()
            .url("https://api.openai.com/v1/chat/completions")
            .post(body)
            .addHeader("Content-Type", "application/json")
            .addHeader("Authorization", "Bearer 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")
            .build()

        val response = client.newCall(request).execute()
        */

        /*val retrofit = HttpUtil.Getinstance("https://api.openai.com/")
        val endpoint = retrofit.create(endpoint::class.java)
        val mediaType = MediaType.parse("application/json")
        val body = RequestBody.create(
            mediaType,
            "{\n    \"model\": \"gpt-3.5-turbo\",\n    \"messages\": [{\"role\": \"user\", \"content\": \"Hello!\"}]\n  }"
        )
        val call = endpoint.getrate(body)

*/

        //println(call)


    }

}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun GreetingPreview(){
    //TopAppBarSample()
}
