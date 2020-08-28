package dz.islem.mvvmkotlin.data.remote

import dz.islem.mvvmkotlin.data.model.Comment
import dz.islem.mvvmkotlin.data.model.Post
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface RemoteApi {

    @GET("/posts")
    fun loadPosts() : Observable<List<Post>>

    @GET("/posts/{id}")
    fun loadPostById(@Path("id") id : Int) : Observable<Post>

    @GET("/posts/{id}/comments")
    fun loadCommentByPost(@Path("id") id : Int) : Observable<List<Comment>>


}