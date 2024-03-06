package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;

/**
 * Represents the graphical user interface for the card game.
 */
public class CardGameUi extends Application {
  private CardGameUiController controller;

  private HandOfCards hand;
  private Label handLabel;

  private Label sumOfFacesLabel;
  private Label cardsOfHeartsLabel;
  private Label flushLabel;
  private Label queenOfSpadesLabel;

  /**
   * Constructs the main window.
   *
   * @param stage The main window.
   */
  @Override
  public void start(Stage stage) {
    this.controller = new CardGameUiController(this);
    BorderPane rootNode = this.createLayout();

    Scene scene = new Scene(rootNode, 600, 400);
    scene.getStylesheets().add("styles.css");

    stage.setScene(scene);
    stage.setTitle("Card Game");
    stage.show();
  }

  /**
   * Creates the layout of the main window.
   *
   * @return The layout of the main window.
   */
  private BorderPane createLayout() {
    BorderPane rootNode = new BorderPane();

    try {
      // THE RIGHT PANE
      Button dealHandButton = new Button("Deal hand");
      dealHandButton.setOnAction(event -> {
        this.controller.doDealHand();
      });
      // creates check hand button
      Button checkHandButton = new Button("Check hand");
      checkHandButton.setOnAction(event -> {
        this.controller.doCheckHand();
      });
      // adds a style class to the buttons
      dealHandButton.getStyleClass().add("button");
      checkHandButton.getStyleClass().add("button");
      // creates a vertical box and adds the buttons to it
      VBox rightPane = new VBox();
      rightPane.getChildren().addAll(dealHandButton, checkHandButton);
      // sets the spacing between the buttons
      rightPane.setSpacing(10);
      // sets the alignment of the buttons to be at the center
      rightPane.setAlignment(Pos.CENTER);

      // BOTTOM PANE
      GridPane bottomPane = new GridPane();
      bottomPane.setAlignment(Pos.CENTER);
      bottomPane.setHgap(40);
      bottomPane.getStyleClass().add("bottom-pane");

      this.sumOfFacesLabel = new Label("Sum of face values: -");
      bottomPane.add(this.sumOfFacesLabel, 0, 0);
      this.cardsOfHeartsLabel = new Label("Cards of hearts: -");
      bottomPane.add(this.cardsOfHeartsLabel, 0, 1);
      this.flushLabel = new Label("Flush: Yes/No"); //TODO: add if the hand is a flush
      bottomPane.add(this.flushLabel, 1, 0);
      this.queenOfSpadesLabel = new Label("Queen of spades: Yes/No"); //TODO: add if the hand contains the queen of spades
      bottomPane.add(this.queenOfSpadesLabel, 1, 1);

      // CENTER PANE
      FlowPane centerPane = new FlowPane();
      this.handLabel = new Label("You have not been dealt a hand yet.\n" +
          " Click the 'Deal hand' button to deal a hand of cards.");
      this.handLabel.getStyleClass().add("hand-label");
      centerPane.setAlignment(Pos.CENTER);
      centerPane.setHgap(10);
      centerPane.getChildren().add(this.handLabel);
      centerPane.getStyleClass().add("center-pane");

      // adds the panes to the layout
      rootNode.setRight(rightPane);
      rootNode.setCenter(centerPane);
      rootNode.setBottom(bottomPane);
      // padding between the panes
      BorderPane.setMargin(rightPane, new Insets(10));
      BorderPane.setMargin(centerPane, new Insets(10));
      BorderPane.setMargin(bottomPane, new Insets(10));

      rootNode.setPadding(new Insets(30));
    } catch (Exception e) {
      System.out.println("An error occurred: " + e.getMessage());
    }

    return rootNode;
  }

  /**
   * Launch the application.
   *
   * @param args Command line arguments.
   */
  public static void appMain(String[] args) {
    launch();
  }

  /**
   * Sets the hand of cards.
   *
   * @param hand The hand of cards.
   */
  public void setHand(PlayingCard[] hand) { //TODO: add images of the cards
    if (hand.length != 5) {
      throw new IllegalArgumentException("The hand must contain exactly 5 cards.");
    }
    this.hand = new HandOfCards(hand);
    this.handLabel.setText(
        this.hand.getHand()[0].getAsString() + ", " +
      this.hand.getHand()[1].getAsString() + ", " +
      this.hand.getHand()[2].getAsString() + ", " +
      this.hand.getHand()[3].getAsString() + ", " +
      this.hand.getHand()[4].getAsString()
    );
  }

  /**
   * Sets the sum of the face values of the cards in the hand.
   *
   * @param sum The sum of the face values of the cards in the hand.
   */
  public void setSumOfFaces(int sum) {
    if (sum < 0) {
      throw new IllegalArgumentException("The sum of the face values cannot be negative.");
    }
    this.sumOfFacesLabel.setText("Sum of face values: " + sum);
  }

  /**
   * Sets the cards of hearts in the hand.
   *
   * @param cardsOfHearts The cards of hearts in the hand.
   */
  public void setCardsOfHearts(ArrayList<PlayingCard> cardsOfHearts) {
    if (cardsOfHearts == null) {
      throw new IllegalArgumentException("The cards of hearts cannot be null.");
    }
    StringBuilder cardsOfHeartsString = new StringBuilder("Cards of hearts: ");
    // adds the cards of hearts to the string
    for (PlayingCard card : cardsOfHearts) {
      cardsOfHeartsString.append(card.getAsString()).append(", ");
    }
    // removes the last comma and space
    cardsOfHeartsString.delete(cardsOfHeartsString.length() - 2, cardsOfHeartsString.length());
    // sets the label
    if (cardsOfHearts.isEmpty()) {
      this.cardsOfHeartsLabel.setText("Cards of hearts: -");
    } else if (cardsOfHeartsString.length() > 0) {
      this.cardsOfHeartsLabel.setText(cardsOfHeartsString.toString());
    }
  }

  /**
   * Sets whether the hand is a 5-flush or not.
   *
   * @param isFlush Whether the hand is a 5-flush or not.
   */
  public void setFlush(boolean isFlush) {
    if (isFlush) {
      this.flushLabel.setText("Flush: Yes");
    } else {
      this.flushLabel.setText("Flush: No");
    }
  }

  /**
   * Sets whether the hand contains the queen of spades or not.
   *
   * @param hasQueenOfSpades Whether the hand contains the queen of spades or not.
   */
  public void setQueenOfSpades(boolean hasQueenOfSpades) {
    if (hasQueenOfSpades) {
      this.queenOfSpadesLabel.setText("Queen of spades: Yes");
    } else {
      this.queenOfSpadesLabel.setText("Queen of spades: No");
    }
  }

  /**
   * Shows an error message if the user tries to check a hand before dealing one.
   */
  public void showErrorMessage() {
    Text errorMessage = new Text("You have to be dealt a hand before you can check it.");
    this.handLabel.setText(errorMessage.getText());
  }
}
