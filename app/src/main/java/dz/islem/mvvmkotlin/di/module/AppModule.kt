package dz.islem.mvvmkotlin.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dz.islem.mvvmkotlin.App
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class AppModule {
    @Singleton
    @Provides
    fun provideContext(app : App) : Context {
        return app
    }
}