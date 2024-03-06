package no.ntnu.idatx2003.oblig3.cardgame;

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
}
