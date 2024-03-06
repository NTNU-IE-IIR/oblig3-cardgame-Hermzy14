package no.ntnu.idatx2003.oblig3.cardgame;

/**
 * Represents the controller for the card game user interface.
 */
public class CardGameUiController {
  private DeckOfCards deck;
  private HandOfCards hand;
  private CardGameUi ui;

  /**
   * Creates a new instance of the controller.
   */
  public CardGameUiController(CardGameUi theUi) {
    this.deck = new DeckOfCards();
    this.ui = theUi;
  }

  public void doDealHand() {
    this.hand = new HandOfCards(this.deck.dealHand(5).getHand());
    this.ui.setHand(this.hand.getHand());
  }

  public void doCheckHand() {
    try {
      this.ui.setSumOfFaces(this.hand.sumOfFaceValues());
      this.ui.setCardsOfHearts(this.hand.cardsOfHearts());
      this.ui.setFlush(this.hand.isFlush());
      this.ui.setQueenOfSpades(this.hand.hasQueenOfSpades());
    } catch (Exception e) {
      this.ui.showErrorMessage();
    }
  }
}
