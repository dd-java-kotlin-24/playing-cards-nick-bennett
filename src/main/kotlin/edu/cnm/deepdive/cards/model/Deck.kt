@file:Suppress("ReplaceJavaStaticMethodWithKotlinAnalog")

package edu.cnm.deepdive.cards.model

import java.util.Collections
import java.util.random.RandomGenerator

class Deck {

    private val cards: MutableList<Card>

    val isEmpty: Boolean
        get() = cards.isEmpty()

    init {
        cards = mutableListOf()
        for (suit in Suit.entries) {
            for (rank in Rank.entries) {
                cards += Card(rank, suit)
            }
        }
    }

    fun shuffle(rng: RandomGenerator) {
        Collections.shuffle(cards, rng)
    }

    fun draw(): Card = cards.removeFirst()
}