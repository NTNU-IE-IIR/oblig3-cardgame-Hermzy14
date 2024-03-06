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
    this.hand = new HandOfCards(this.deck.dealHand(5).getHand());
    this.ui = theUi;
  }

  public void doDealHand() {
    this.hand = new HandOfCards(this.deck.dealHand(5).getHand());
    this.ui.setHand(this.hand.getHand());
  }

  public void doCheckHand() {
    System.out.println("Checking hand");
  }
}
