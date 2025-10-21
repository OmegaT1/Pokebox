package com.example.pokebox

import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pokebox.data.PokemonCard
import com.example.pokebox.data.PokemonSet
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btsv8 = findViewById<Button>(R.id.btloadSV8)
        val btsv9 = findViewById<Button>(R.id.btloadSV9)
        val btlista = findViewById<Button>(R.id.btcard)



        val SinputStream = assets.open("json/sets/en.json")
        val Sreader = JsonReader(SinputStream.reader())
        val Stype = object : TypeToken<List<PokemonSet>>() {}.type
        val sets: List<PokemonSet> = Gson().fromJson(Sreader, Stype)
        Sreader.close()


        btsv8.setOnClickListener{
            cargardatos(sets, "sv8")
        }

        btsv9.setOnClickListener{
            cargardatos(sets, "sv9")
        }

        btlista.setOnClickListener {
            cargardatos(sets, "base1")
        }




    }

    fun cargarinfoset(sets : List<PokemonSet>, id: String): PokemonSet? {
        val set : PokemonSet? = sets.find{it.id == id}
        return set
    }

    fun cargardatos(sets : List<PokemonSet>, id: String) {

        val listView = findViewById<ListView>(R.id.listview)
        val tview = findViewById<TextView>(R.id.testtexto)

        val set : PokemonSet? = cargarinfoset(sets, id)
        val nombre : String = set?.name ?: "error"
        val series : String = set?.series ?: "error"
        val total : Int = set?.total ?: 0
        val printedtotal : Int = set?.printedTotal ?: 0

        tview.text = "Set name: " + nombre +
                "\n" + "Series: " + series +
                "\n" + "Cards: " + printedtotal + "/" + total


        val CinputStream = assets.open("json/cards/en/" + id + ".json")
        val Creader = JsonReader(CinputStream.reader())
        val Ctype = object : TypeToken<List<PokemonCard>>() {}.type
        val cards: List<PokemonCard> = Gson().fromJson(Creader, Ctype)
        Creader.close()

        val adapter = ListAdapter(this, cards)
        listView.adapter = adapter
    }
}