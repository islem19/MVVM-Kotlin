package dz.islem.mvvmkotlin.ui.detail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import dz.islem.mvvmkotlin.data.DataManager
import dz.islem.mvvmkotlin.data.model.Comment
import dz.islem.mvvmkotlin.data.model.Post
import dz.islem.mvvmkotlin.ui.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DetailViewModel(val dataManager : DataManager) : BaseViewModel() {
    private var post = MutableLiveData<Post>()
    private var comments = MutableLiveData<List<Comment>>()

    fun getPost() : MutableLiveData<Post> {
        return post
    }

    fun getComments() : MutableLiveData<List<Comment>> {
        return comments
    }

    fun loadPost(id : Int){
        compositeDisposable?.add(
            dataManager.loadPostById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    post.postValue(it)
                }, {
                    Log.e("TAG", "loadPost: $it")
                })
        )
    }

    fun loadComments(id : Int){
        compositeDisposable?.add(
            dataManager.loadCommentByPost(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    comments.postValue(it)
                }, {
                    Log.e("TAG", "loadComments: $it")
                })
        )
    }
}