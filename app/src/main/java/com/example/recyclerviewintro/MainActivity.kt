package com.example.recyclerviewintro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    var persons = mutableListOf<Person>(
                                Person("David", 43),
                                Person("Susan", 37),
                                Person("Lois", 8),
                                Person("Laura", 11)
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (i in 1..100) {
            persons.add(Person("Elisabet", i))
        }


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)

        // skapa en adapter från vår adapter-klass, skicka med vår lista
        val adapter = PersonRecycleAdapter(this, persons)

        // koppla ihop vår adapter med recyclerview:n
        recyclerView.adapter = adapter
    }
}