package com.example.tp_epsi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toolbar
import com.google.android.material.appbar.AppBarLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val appBar = findViewById<AppBarLayout>(R.id.appBar)
//        appBar.addView(Toolbar(this))

        val category= arrayListOf<Category>()
        val recyclerViewCategory= findViewById<RecyclerView>(R.id.recyclerViewCategory)
        recyclerViewCategory.layoutManager= LinearLayoutManager(this)
        val categoryAdapter=CategoryAdapter(category)
        recyclerViewCategory.adapter=categoryAdapter
        val progressBar=findViewById<ProgressBar>(R.id.progressBar)
        progressBar.visibility=View.VISIBLE

    }
}