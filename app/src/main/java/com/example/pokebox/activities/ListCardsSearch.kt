package com.example.pokebox.activities

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokebox.R
import com.example.pokebox.adapters.ListCardsSearchAdapter
import com.example.pokebox.data.PokemonCard
import com.example.pokebox.data.PokemonSet
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader

class ListCardsSearch : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_cards_search)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rview = findViewById<RecyclerView>(R.id.rviewcardsearch)

        val set = intent.getParcelableExtra<PokemonSet>("pset")
        if (set != null) {

            val CinputStream = assets.open("json/cards/en/" + set.id + ".json")
            val Creader = JsonReader(CinputStream.reader())
            val Ctype = object : TypeToken<List<PokemonCard>>() {}.type
            val cards: List<PokemonCard> = Gson().fromJson(Creader, Ctype)
            Creader.close()

            val lmanager = LinearLayoutManager(this)
            rview.layoutManager = lmanager
            rview.clipToPadding = false
            rview.setPadding(16, 16, 16, 16)

            rview.adapter = ListCardsSearchAdapter(this, set, cards) { selectedCard ->
                Toast.makeText(this, "Pulsado: ${selectedCard.name}", Toast.LENGTH_SHORT).show()
            }




        }









    }
}