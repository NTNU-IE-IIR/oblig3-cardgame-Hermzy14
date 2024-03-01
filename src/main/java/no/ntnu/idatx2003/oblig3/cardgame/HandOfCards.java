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
}
