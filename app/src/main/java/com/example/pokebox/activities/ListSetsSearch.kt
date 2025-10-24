package com.example.pokebox.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokebox.R
import com.example.pokebox.adapters.ListSetsSearchAdapter
import com.example.pokebox.data.PokemonSet
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader

class ListSetsSearch : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_sets_search)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rview = findViewById<RecyclerView>(R.id.rviewsetsearch)

        val SinputStream = assets.open("json/sets/en.json")
        val Sreader = JsonReader(SinputStream.reader())
        val Stype = object : TypeToken<List<PokemonSet>>() {}.type
        val sets: List<PokemonSet> = Gson().fromJson(Sreader, Stype)
        Sreader.close()

        val lmanager = LinearLayoutManager(this)
        rview.layoutManager = lmanager
        rview.clipToPadding = false
        rview.setPadding(16, 16, 16, 16)

        rview.adapter = ListSetsSearchAdapter(this, sets) { selectedSet ->
            //Toast.makeText(this, "Pulsado: ${selectedSet.name}", Toast.LENGTH_SHORT).show()

            val i = Intent(this, ListCardsSearch::class.java)
            i.putExtra("pset", selectedSet)
            this.startActivity(i)

        }


    }

}