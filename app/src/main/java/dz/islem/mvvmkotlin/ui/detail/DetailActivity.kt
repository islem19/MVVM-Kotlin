package dz.islem.mvvmkotlin.ui.detail

import android.os.Bundle
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dz.islem.mvvmkotlin.R
import dz.islem.mvvmkotlin.data.DataManager
import dz.islem.mvvmkotlin.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : BaseActivity<DetailViewModel>() {
    private var postId : Int ?= null
    private lateinit var detailAdapter : DetailAdapter

    override fun createViewModel(): DetailViewModel {
        val detailViewModelFactory = DetailViewModelFactory(DataManager)
        return ViewModelProvider(this,detailViewModelFactory).get(DetailViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        postId = intent.getIntExtra("postId",1)
        detailAdapter = DetailAdapter()
        setupRecyclerView()
        viewModel.getPost().observe(this, Observer {
            tv_post_title.text = it.title
            tv_post_body.text = it.body
        })
        viewModel.getComments().observe(this, Observer {
            detailAdapter.addComments(it)
        })

        viewModel.loadPost(postId!!)
        viewModel.loadComments(postId!!)

    }

    private fun setupRecyclerView() {
        recycler_view_comments.layoutManager = LinearLayoutManager(this)
        recycler_view_comments.adapter = detailAdapter
    }
}
