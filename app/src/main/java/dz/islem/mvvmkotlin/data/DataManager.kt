package dz.islem.mvvmkotlin.data

import dz.islem.mvvmkotlin.data.model.Comment
import dz.islem.mvvmkotlin.data.model.Post
import dz.islem.mvvmkotlin.data.remote.RemoteApi
import dz.islem.mvvmkotlin.data.remote.RemoteService
import io.reactivex.Observable

object DataManager {
    var remoteApi : RemoteApi

    init {
        remoteApi = RemoteService.buildService(RemoteApi::class.java)
    }

    fun loadPosts() : Observable<List<Post>>{
        return remoteApi.loadPosts()
    }

    fun loadPostById(id : Int) : Observable<Post>{
        return remoteApi.loadPostById(id)
    }

    fun loadCommentByPost(id : Int) : Observable<List<Comment>>{
        return remoteApi.loadCommentByPost(id)
    }


}