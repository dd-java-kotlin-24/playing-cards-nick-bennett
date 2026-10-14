package edu.cnm.deepdive.cards

import edu.cnm.deepdive.cards.games.Trick
import edu.cnm.deepdive.cards.model.Card
import edu.cnm.deepdive.cards.model.Deck
import edu.cnm.deepdive.cards.model.Suit
import kotlin.random.Random

fun main() {
    val deck = Deck()
    val rng = Random.Default
    val trick = Trick(rng)
    trick.performMagic(deck)
    println(trick.blackPile.sortedWith(blackFirstComparator))
    println(trick.redPile.sortedWith(redFirstComparator))
}

private val colorComparator: Comparator<Card> =
    Comparator.comparing(Card::suit, Comparator.comparing(Suit::color))

private val blackFirstComparator: Comparator<Card> =
    colorComparator.thenComparing(Comparator.naturalOrder())

private val redFirstComparator: Comparator<Card> =
    colorComparator.reversed().thenComparing(Comparator.naturalOrder())
