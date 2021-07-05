package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.recyclerview.adapter.NotasAdapter
import com.example.recyclerview.modelo.Nota
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var recyclerNotas:RecyclerView

    lateinit var app:NotaApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerNotas = findViewById(R.id.listaNotas)

        app = applicationContext as NotaApp

        val notas = ArrayList<Nota>()
        notas.add(Nota(titulo = "Primera nota", descripcion = "una descripcion"))
        notas.add(Nota(titulo = "Primera nota -1", descripcion = "una descripcion un poco mas larga"))
        notas.add(Nota(titulo = "Primera nota 0", descripcion = "una descripcion"))
        notas.add(Nota(titulo = "Primera nota 1", descripcion = "una descripcion"))
        notas.add(Nota(titulo = "Primera nota 2", descripcion = "una descripcion muchisisisisisisisisiisisisisisisisisisisisismuchisisisisisisisisiisisisisisisisisisisisismuchisisisisisisisisiisisisisisisisisisisisismuchisisisisisisisisiisisisisisisisisisisisismuchisisisisisisisisiisisisisisisisisisisisismuchisisisisisisisisiisisisisisisisisisisisis mas larga"))
        notas.add(Nota(titulo = "Primera nota 3", descripcion = "una descripcion"))
        notas.add(Nota(titulo = "Primera nota 4", descripcion = "una descripcion"))
        notas.add(Nota(titulo = "Primera nota 5", descripcion = "una descripcion"))

        recyclerNotas.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        recyclerNotas.setHasFixedSize(true)
        recyclerNotas.adapter = NotasAdapter(notas,this)



    }

    override fun onResume() {
        super.onResume()
        lifecycleScope.launch{
            val notas = app.room.notaDao().obtenerTodas()
        }
    }

}