package com.example.tp_epsi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toolbar
import com.google.android.material.appbar.AppBarLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.CacheControl
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val appBar = findViewById<AppBarLayout>(R.id.appBar)
//        appBar.addView(Toolbar(this))

        val category = arrayListOf<Category>()
        val recyclerViewCategory = findViewById<RecyclerView>(R.id.recyclerViewCategory)
        recyclerViewCategory.layoutManager = LinearLayoutManager(this)
        val categoryAdapter = CategoryAdapter(category)
        recyclerViewCategory.adapter = categoryAdapter
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        progressBar.visibility = View.VISIBLE

        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val mRequestUrl = "https://ugarit.online/epsi/categories.json"
        val request =
            Request.Builder().url(mRequestUrl).get().cacheControl(CacheControl.FORCE_NETWORK)
                .build()
        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call, response: Response) {
                val data = response.body()?.string()
                if (data != null) {
                    val jsStudents = JSONObject(data)
                    val jsArrayStudents = jsStudents.getJSONArray("items")
                    for (i in 0 until jsArrayStudents.length()) {
                        val js = jsArrayStudents.getJSONObject(i)
                        val student = Category(
                            js.optString("products_url", ""),
                            js.optString("category_id", ""),
                            js.optString("title", "le titre"),
                        )
                        category.add(student)
                    }
                    runOnUiThread {
                        categoryAdapter.notifyDataSetChanged()
                        progressBar.visibility = View.GONE
                    }

                }
            }
        })

    }
}