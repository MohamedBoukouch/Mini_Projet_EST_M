package com.boukouch.mini_projet

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.boukouch.mini_projet.adapter.NewsItemAdapter
import com.boukouch.mini_projet.model.NewsItem

class MainActivity_avis : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_avis)
    }

    
}

// Extension function to set up the RecyclerView with a news adapter
fun RecyclerView.setupNewsRecyclerView(newsList: List<NewsItem>) {
    adapter = NewsItemAdapter(newsList)
    layoutManager = LinearLayoutManager(context)
}
