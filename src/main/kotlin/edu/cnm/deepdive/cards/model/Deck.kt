@file:Suppress("ReplaceJavaStaticMethodWithKotlinAnalog")

package edu.cnm.deepdive.cards.model

import kotlin.random.Random

class Deck {

    private val cards: MutableList<Card> = mutableListOf()

    val isEmpty: Boolean
        get() = cards.isEmpty()

    init {
        for (suit in Suit.entries) {
            for (rank in Rank.entries) {
                cards += Card(rank, suit)
            }
        }
    }

    fun shuffle(rng: Random? = null) {
        if (rng == null) {
            cards.shuffle()
        } else {
            cards.shuffle(rng)
        }
    }

    fun draw(): Card = cards.removeFirst()
}