package dz.islem.mvvmkotlin.di.module

import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dz.islem.mvvmkotlin.data.DataManager
import dz.islem.mvvmkotlin.ui.detail.DetailViewModel
import dz.islem.mvvmkotlin.ui.detail.DetailViewModelFactory


@InstallIn(ActivityComponent::class)
@Module
class DetailActivityModule {
    @Provides
    fun provideViewModel(dataManager: DataManager) : DetailViewModel{
        return DetailViewModel(dataManager)
    }

    @Provides
    fun provideVMFactory(VM : DetailViewModel): DetailViewModelFactory {
        return DetailViewModelFactory(VM)
    }
}