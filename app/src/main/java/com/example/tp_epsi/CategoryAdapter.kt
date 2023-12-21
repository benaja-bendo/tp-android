package com.example.tp_epsi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter(private val category: ArrayList<Category>):RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    class ViewHolder(view:View) :RecyclerView.ViewHolder(view){
        val textViewId = view.findViewById<TextView>(R.id.id)
        val textViewTitle = view.findViewById<TextView>(R.id.title)
        val textViewUrl = view.findViewById<TextView>(R.id.url)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cell_category, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return category.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student=this.category.get(position)
        holder.textViewId.text=student.categoryId
        holder.textViewUrl.text=student.productsUrl
        holder.textViewTitle.text=student.title

//        Glide.with(holder.imageViewStudent.context).load(student.imgUrl).into(holder.imageViewStudent);
    }
}