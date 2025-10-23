package com.example.pokebox.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pokebox.R
import com.example.pokebox.data.CardRepository

class MainMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btsetsearch = findViewById<Button>(R.id.btListSets)
        val btadvsearch = findViewById<Button>(R.id.btAdvSearch)
        val btsetperc = findViewById<Button>(R.id.btListSetsPerc)
        val btcompmazo = findViewById<Button>(R.id.btCompMazo)

        btsetsearch.setOnClickListener {
            val i = Intent(this, ListSetsSearch::class.java)
            this.startActivity(i)
        }

        btadvsearch.setOnClickListener {
            if (CardRepository.getCards().size == 0) {
                val i = Intent(this, LoadingActivity::class.java)
                this.startActivity(i)
            } else {
                val i = Intent(this, AdvancedSearch::class.java)
                this.startActivity(i)
            }
        }


    }
}