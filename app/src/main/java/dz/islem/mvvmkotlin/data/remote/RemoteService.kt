package dz.islem.mvvmkotlin.data.remote

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

object RemoteService {

    val retrofit : Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory(MediaType.get("application/json")))
        .baseUrl("https://jsonplaceholder.typicode.com")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()


    fun<T> buildService(service: Class<T>): T{
        return retrofit.create(service)
    }
}