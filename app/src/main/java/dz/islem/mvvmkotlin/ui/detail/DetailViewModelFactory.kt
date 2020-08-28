package dz.islem.mvvmkotlin.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dz.islem.mvvmkotlin.data.DataManager
import java.lang.IllegalArgumentException
import javax.inject.Inject

class DetailViewModelFactory (val VM : DetailViewModel) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(VM.javaClass)){
            return VM as T
        }
        throw IllegalArgumentException("Unknown viewModel")
    }

}