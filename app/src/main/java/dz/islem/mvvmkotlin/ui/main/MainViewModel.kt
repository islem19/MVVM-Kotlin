package dz.islem.mvvmkotlin.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import dz.islem.mvvmkotlin.data.DataManager
import dz.islem.mvvmkotlin.data.model.Post
import dz.islem.mvvmkotlin.ui.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(val dataManager : DataManager) : BaseViewModel() {
    private var posts = MutableLiveData<List<Post>>()

    fun getPosts() : MutableLiveData<List<Post>> {
        return posts
    }

    fun loadPosts(){
        compositeDisposable?.add(
            dataManager.loadPosts()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    posts.postValue(it)
                }, {
                    Log.e("TAG", "LoadPosts: $it")
                }
                )
        )
    }

}