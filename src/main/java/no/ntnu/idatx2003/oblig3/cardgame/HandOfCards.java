package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.ArrayList;

/**
 * Represents a hand of cards. A hand of cards is a collection of playing cards.
 */
public class HandOfCards {
  private final PlayingCard[] hand;

  /**
   * Creates a new instance of a hand of cards.
   *
   * @param hand The cards to add to the hand
   */
  public HandOfCards(PlayingCard[] hand) {
    this.hand = hand;
  }

  /**
   * Returns the hand of cards
   *
   * @return the hand of cards
   */
  public PlayingCard[] getHand() {
    return this.hand;
  }

  /**
   * Returns the sum of the face values of the cards in the hand.
   */
  public int sumOfFaceValues() {
    int sum = 0;
    for (PlayingCard card : this.hand) {
      sum += card.getFace();
    }
    return sum;
  }

  /**
   * Returns the cards of hearts in the hand.
   *
   * @return the cards of hearts in the hand
   */
  public ArrayList<PlayingCard> cardsOfHearts() {
    ArrayList<PlayingCard> cardsOfHearts = new ArrayList<>();
    for (PlayingCard card : this.hand) {
      if (card.getSuit() == 'H') {
        cardsOfHearts.add(card);
      }
    }
    return cardsOfHearts;
  }

  /**
   * Returns whether the hand is a flush or not.
   *
   * @return whether the hand is a flush or not. Returns true if the hand is a flush,
   * and false if it is not.
   */
  public boolean isFlush() {
    boolean isFlush = false;

    if (
        this.hand[0].getSuit() == this.hand[1].getSuit() &&
        this.hand[1].getSuit() == this.hand[2].getSuit() &&
        this.hand[2].getSuit() == this.hand[3].getSuit() &&
        this.hand[3].getSuit() == this.hand[4].getSuit()
    ) {
      isFlush = true;
    }

    return isFlush;
  }

  /**
   * Returns whether the hand has the queen of spades or not.
   *
   * @return whether the hand has the queen of spades or not.
   * Returns true if the hand has the queen of spades, and false if it does not.
   */
  public boolean hasQueenOfSpades() {
    boolean hasQueenOfSpades = false;

    for (PlayingCard card : this.hand) {
      if (card.getFace() == 12 && card.getSuit() == 'S') {
        hasQueenOfSpades = true;
      }
    }

    return hasQueenOfSpades;
  }
}
