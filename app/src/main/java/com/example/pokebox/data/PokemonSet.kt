package com.example.pokebox.data

data class PokemonSet(
    val id: String,
    val name: String,
    val series: String,
    val printedTotal: Int,
    val total: Int,
    val legalities: Map<String, String>,
    val ptcgoCode: String,
    val releaseDate: String,
    val updatedAt: String,
    val images: Images
)

data class Images(
    val symbol: String,
    val logo: String
)
