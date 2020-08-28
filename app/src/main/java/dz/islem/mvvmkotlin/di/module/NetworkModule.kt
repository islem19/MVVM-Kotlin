package dz.islem.mvvmkotlin.di.module

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dz.islem.mvvmkotlin.data.DataManager
import dz.islem.mvvmkotlin.data.remote.RemoteApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import javax.inject.Named
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(@Named("jsonplaceholder") url: String,
                        rxJava2CallAdapterFactory : RxJava2CallAdapterFactory) : Retrofit {
        return Retrofit.Builder()
            .addCallAdapterFactory(rxJava2CallAdapterFactory)
            .addConverterFactory(Json.asConverterFactory(MediaType.get("application/json")))
            .baseUrl(url).build()
    }

    @Provides
    fun provideRxJava2CallAdapterFactory() : RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create()
    }

    @Provides
    @Named("jsonplaceholder")
    fun provideUrl() : String {
        return "https://jsonplaceholder.typicode.com"
    }

    @Provides
    fun provideApi(retrofit : Retrofit) : RemoteApi{
        return retrofit.create(RemoteApi::class.java)
    }

    @Provides
    @Singleton
    fun provideDataManager(remoteApi : RemoteApi) : DataManager {
        return DataManager(remoteApi)
    }
}