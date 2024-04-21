package com.victor.practicaapp.todoApp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.victor.practicaapp.R
import com.victor.practicaapp.todoApp.TaskCategory.*

class TodoActivity : AppCompatActivity() {

    private val categorias = listOf(
        Personal,
        Business,
        Other
    )

    private val tasks = mutableListOf(
        Task("Prueba negocio", Business),
        Task("Prueba personal", Personal),
        Task("Prueba otro", Other)
    )

    private lateinit var rvCategorias: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var rvTareas: RecyclerView
    private lateinit var fabAddTask:FloatingActionButton

    private lateinit var tasksAdapter: TasksAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
        initComponents()
        initUI()
        initListeners()

    }


    private fun initComponents() {
        rvCategorias = findViewById(R.id.rvCategorias)
        rvTareas = findViewById(R.id.rvTareas)
        fabAddTask = findViewById(R.id.fabAddTask)

    }

    private fun initListeners() {
        fabAddTask.setOnClickListener { showDialog() }
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_add_task)

        val btnAddTask: Button = dialog.findViewById(R.id.btnAddTask)
        val etTarea: EditText = dialog.findViewById(R.id.etTarea)
        val rgCategorias: RadioGroup = dialog.findViewById(R.id.rgCategorias)


        btnAddTask.setOnClickListener {
            val tarea = etTarea.text.toString()
            if (tarea.isNotEmpty()) {
                val selectedId = rgCategorias.checkedRadioButtonId
                val selectedRadioButton = rgCategorias.findViewById<RadioButton>(selectedId)
                val categoriaActual: TaskCategory = when(selectedRadioButton.text){
                    getString(R.string.negocios) -> Business
                    getString(R.string.personal) -> Personal
                    else -> Other
                }
                tasks.add(Task(tarea, categoriaActual))
                updateTasks()
                dialog.hide()
            } else
                Toast.makeText(this, "No puedes agregar una tarea sin nombre", Toast.LENGTH_SHORT).show()
        }

        dialog.show()
    }


    private fun initUI() {
        categoriesAdapter = CategoriesAdapter(categorias) {updateCategories(it)}
        rvCategorias.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategorias.adapter = categoriesAdapter

        tasksAdapter = TasksAdapter(tasks) {onItemSelected(it)}
        rvTareas.layoutManager = LinearLayoutManager(this)
        rvTareas.adapter = tasksAdapter

    }

    private fun updateCategories(position: Int){
        categorias[position].isSelected = !categorias[position].isSelected
        categoriesAdapter.notifyItemChanged(position)
        updateTasks()
    }

    private fun onItemSelected(position:Int) {
        tasks[position].isSelected = !tasks[position].isSelected
        updateTasks()
    }

    private fun updateTasks() {
        val selectedCategories: List<TaskCategory> = categorias.filter { it.isSelected }
        val newTask = tasks.filter { selectedCategories.contains(it.category) }
        tasksAdapter.tasks = newTask
        tasksAdapter.notifyDataSetChanged()
    }
}