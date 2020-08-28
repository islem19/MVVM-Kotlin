package dz.islem.mvvmkotlin.ui.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dz.islem.mvvmkotlin.R
import dz.islem.mvvmkotlin.data.model.Comment
import dz.islem.mvvmkotlin.ui.main.MainAdapter
import javax.inject.Inject

class DetailAdapter @Inject constructor(): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var comments = ArrayList<Comment>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_comment, parent,false)
        return CommentHolder(view)
    }

    override fun getItemCount(): Int {
        return comments.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as CommentHolder).setName(comments.get(position).name)
        (holder as CommentHolder).setEmail(comments.get(position).email)
        (holder as CommentHolder).setComment(comments.get(position).body)
    }

    fun getComment(position: Int) : Comment {
        return comments.get(position)
    }

    fun clear() {
        comments.clear()
        notifyDataSetChanged()
    }

    fun addComments(comments : List<Comment>){
        this.comments.addAll(comments)
        notifyDataSetChanged()
    }

    class CommentHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var nameView : TextView = view.findViewById(R.id.tv_user)
        private var emailView : TextView = view.findViewById(R.id.tv_email)
        private var commentView : TextView = view.findViewById(R.id.tv_comment)

        fun setName(name : String){
            nameView.text = name
        }
        fun setEmail(email : String){
            emailView.text = email
        }
        fun setComment(comment : String){
            commentView.text = comment
        }
    }
}