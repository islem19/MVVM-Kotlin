package dz.islem.mvvmkotlin.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dz.islem.mvvmkotlin.data.DataManager
import java.lang.IllegalArgumentException

class MainViewModelFactory(val VM : MainViewModel) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(VM.javaClass))
            return VM as T
        throw IllegalArgumentException("Unknown Argument")
    }
}