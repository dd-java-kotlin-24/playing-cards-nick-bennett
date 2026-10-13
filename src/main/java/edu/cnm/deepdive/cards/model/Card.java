package edu.cnm.deepdive.cards.model;

import java.util.Comparator;
import org.jspecify.annotations.NonNull;

/**
 * Encapsulates the attributes and basic operations of a standard playing card.
 *
 * @param rank One of Ace through King.
 * @param suit One of Clubs, Diamonds, Hearts, Spades.
 */
public record Card(Rank rank, Suit suit) implements Comparable<Card> {

  private static final Comparator<Card> SHRINK_WRAP_COMPARATOR =
      Comparator.comparing(Card::suit)
          .thenComparing(Card::rank);

  @Override
  public int compareTo(@NonNull Card otherCard) {
    return SHRINK_WRAP_COMPARATOR.compare(this, otherCard);
  }

}
