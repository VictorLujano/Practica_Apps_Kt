package com.victor.practicaapp.todoApp

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.victor.practicaapp.R

class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val tvCategoriaNombre:TextView = view.findViewById(R.id.tvCategoriaNombre)
    private val divider:View = view.findViewById(R.id.divider)
    private val viewContainer:CardView = view.findViewById(R.id.viewContainer)

    fun render(taskCategory: TaskCategory, onItemSelected: (Int) -> Unit) {

        val color = if(taskCategory.isSelected) {
            R.color.todo_background_card
        } else {
            R.color.todo_background_disabled
        }

        viewContainer.setCardBackgroundColor(ContextCompat.getColor(divider.context, color))


        itemView.setOnClickListener { onItemSelected(layoutPosition) }

        when(taskCategory) {
            TaskCategory.Business -> {
                tvCategoriaNombre.text = "Negocios"
                divider.setBackgroundColor(ContextCompat.getColor(divider.context, R.color.todo_business_category))
            }
            TaskCategory.Other -> {
                tvCategoriaNombre.text = "Otros"
                divider.setBackgroundColor(ContextCompat.getColor(divider.context, R.color.todo_other_category))

            }
            TaskCategory.Personal -> {
                tvCategoriaNombre.text = "Personals"
                divider.setBackgroundColor(ContextCompat.getColor(divider.context, R.color.todo_personal_category))

            }
        }
    }
}