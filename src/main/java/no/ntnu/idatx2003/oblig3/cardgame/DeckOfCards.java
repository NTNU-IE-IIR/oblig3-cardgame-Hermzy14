package no.ntnu.idatx2003.oblig3.cardgame;

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
}
