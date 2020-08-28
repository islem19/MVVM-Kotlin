package dz.islem.mvvmkotlin.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dz.islem.mvvmkotlin.data.DataManager
import java.lang.IllegalArgumentException

class DetailViewModelFactory(val dataManager : DataManager) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(DetailViewModel::class.java)){
            return DetailViewModel(dataManager) as T
        }
        throw IllegalArgumentException("Unknown viewModel")
    }

}