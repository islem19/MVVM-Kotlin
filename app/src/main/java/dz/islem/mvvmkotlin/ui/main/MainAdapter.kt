package dz.islem.mvvmkotlin.ui.main

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dz.islem.mvvmkotlin.App
import dz.islem.mvvmkotlin.R
import dz.islem.mvvmkotlin.data.model.Post
import dz.islem.mvvmkotlin.ui.detail.DetailActivity
import javax.inject.Inject

class MainAdapter @Inject constructor() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent,false)
        return PostHolder(view)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PostHolder).setTitle(posts.get(position).title)
        (holder as PostHolder).setBody(posts.get(position).body)
    }

    fun getPost(position : Int) : Post {
        return posts.get(position)
    }

    fun clear() {
        posts.clear()
        notifyDataSetChanged()
    }

    fun addPosts(posts : List<Post>) {
        MainAdapter.posts.addAll(posts)
        notifyDataSetChanged()
    }

    class PostHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val titleView : TextView = view.findViewById(R.id.tv_post_title)
        private val bodyView : TextView = view.findViewById(R.id.tv_post_body)

        init {
            view.setOnClickListener{
                startDetails(layoutPosition)
            }
        }

        fun setTitle(title:String) {
            titleView.text = title
        }

        fun setBody(body:String) {
            bodyView.text = body
        }
    }

    companion object {
        private var posts = ArrayList<Post>()

        private fun startDetails(layoutPosition: Int) {
            var item = posts.get(layoutPosition)
            var mIntent = Intent(App.instance, DetailActivity::class.java)
            mIntent.putExtra("postId",item.id)
            App.instance.startActivity(mIntent)
        }
    }



}
