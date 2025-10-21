package com.example.pokebox.data

data class PokemonCard(
    val id: String,
    val name: String,
    val supertype: String,
    val subtypes: List<String>?,
    val level: String?,
    val hp: String?,
    val types: List<String>?,
    val evolvesFrom: String?,
    val evolvesTo: List<String>?,
    val abilities: List<Ability>?,
    val attacks: List<Attack>?,
    val weaknesses: List<Weakness>?,
    val resistances: List<Resistance>?,
    val retreatCost: List<String>?,
    val convertedRetreatCost: Int?,
    val number: String?,
    val artist: String?,
    val rarity: String?,
    val flavorText: String?,
    val nationalPokedexNumbers: List<Int>?,
    val legalities: Legalities?,
    val images: CardImages?
)

data class Ability(
    val name: String,
    val text: String,
    val type: String
)

data class Attack(
    val name: String,
    val cost: List<String>?,
    val convertedEnergyCost: Int?,
    val damage: String?,
    val text: String?
)

data class Weakness(
    val type: String,
    val value: String
)

data class Resistance(
    val type: String,
    val value: String
)

data class Legalities(
    val unlimited: String?,
    val expanded: String?,
    val standard: String?
)

data class CardImages(
    val small: String?,
    val large: String?
)
