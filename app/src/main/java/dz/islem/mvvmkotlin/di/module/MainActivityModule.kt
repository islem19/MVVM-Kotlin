package dz.islem.mvvmkotlin.di.module

import android.app.Activity
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dz.islem.mvvmkotlin.data.DataManager
import dz.islem.mvvmkotlin.ui.main.MainViewModel
import dz.islem.mvvmkotlin.ui.main.MainViewModelFactory


@InstallIn(ActivityComponent::class)
@Module
class MainActivityModule {

    @Provides
    fun provideViewModel(dataManager: DataManager) : MainViewModel{
        return MainViewModel(dataManager)
    }

    @Provides
    fun provideVMFactory(VM : MainViewModel): MainViewModelFactory{
        return MainViewModelFactory(VM)
    }
}