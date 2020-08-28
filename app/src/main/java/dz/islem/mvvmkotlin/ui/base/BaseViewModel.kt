package dz.islem.mvvmkotlin.ui.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {

    var compositeDisposable: CompositeDisposable? = CompositeDisposable()

    fun cleanupVM(){
        compositeDisposable?.dispose()
    }
}