package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.Random;

/**
 * Represents a deck of cards. A deck of cards has 52 cards, 13 of each suit.
 */
public class DeckOfCards {
  private final char[] suits = {'S', 'H', 'D', 'C'};
  private final int[] faces = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
  private final PlayingCard[] deck = new PlayingCard[52];

  /**
   * Creates a new instance of a deck of cards.
   */
  public DeckOfCards() {
    int i = 0;
    for (char suit : this.suits) {
      for (int face : this.faces) {
        this.deck[i++] = new PlayingCard(suit, face);
      }
    }
  }

  /**
   * Deals a random hand of cards from the deck and returns them as a collection.
   *
   * @param n The random number of cards to deal
   * @return A collection of n cards
   */
  public HandOfCards dealHand(int n) {
    if (n > this.deck.length) {
      throw new IllegalArgumentException("Cannot deal more cards than there are in the deck");
    }

    Random random = new Random();
    PlayingCard[] hand = new PlayingCard[n];
    // Deal n cards
    for (int i = 0; i < n; i++) {
      // Pick a random card from the deck
      int index = random.nextInt(this.deck.length);
      // Checks to see if the card is already in the hand
      for (PlayingCard card : hand) {
        // If the card is already in the hand, pick a new card
        if (card == this.deck[index]) {
          index = random.nextInt(this.deck.length);
        }
      }
      // If the card is not in the hand, add it to the hand
      hand[i] = this.deck[index];
    }

    return new HandOfCards(hand);
  }
}
