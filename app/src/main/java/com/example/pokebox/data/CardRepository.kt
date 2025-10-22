package com.example.pokebox.data

class CardRepository {
    private var allCards: MutableList<PokemonCard> = mutableListOf()

    fun addCards(cards: List<PokemonCard>) {
        allCards.addAll(cards)
    }

    fun getCards(): List<PokemonCard> = allCards

    fun clear() {
        allCards.clear()
    }
}