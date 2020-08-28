package dz.islem.mvvmkotlin.ui.main

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dz.islem.mvvmkotlin.R
import dz.islem.mvvmkotlin.data.DataManager
import dz.islem.mvvmkotlin.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainViewModel>() {
    private lateinit var mainAdapter : MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainAdapter = MainAdapter()
        setupRecyclerView()
        viewModel.getPosts().observe(this, Observer {
            mainAdapter.addPosts(it)
        })
        viewModel.loadPosts()
    }

    private fun setupRecyclerView() {
        recycler_view_posts.layoutManager = LinearLayoutManager(this)
        recycler_view_posts.adapter = mainAdapter
    }

    override fun createViewModel(): MainViewModel {
        var mainViewModelFactory = MainViewModelFactory(DataManager)
        return ViewModelProvider(this,mainViewModelFactory).get(MainViewModel::class.java)
    }

}
