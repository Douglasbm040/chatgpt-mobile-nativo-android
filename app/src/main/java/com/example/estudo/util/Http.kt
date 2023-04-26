import com.example.estudo.api.endpoint
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object HttpUtil{
    private const val BASE_URL = "https://api.openai.com/"
    private  val httpClient = OkHttpClient.Builder().build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService : endpoint = retrofit.create(endpoint::class.java)
    /*companion object{
        fun Getinstance(path:String) : Retrofit {
            return Retrofit.Builder()
                    .baseUrl(path)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }
    }*/
}