package com.example.pokebox.data



data class CardFilter(

    val nombre: String? = null,
    val supertype: String? = null,
    val subtype: String? = null,
    val type: String? = null,
    val legality: String? = null,
    val rarity: String? = null,
    val artist: String? = null,
    val hasability: Boolean? = null,
    val minHP: Int? = null,
    val maxHP: Int? = null


)
