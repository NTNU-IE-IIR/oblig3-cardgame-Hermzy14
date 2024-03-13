package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.ArrayList;
import javafx.animation.Animation;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Represents the graphical user interface for the card game.
 */
public class CardGameUi extends Application {
  private CardGameUiController controller;

  private HandOfCards hand;
  private FlowPane handView;

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
      // adds the panes to the layout
      rootNode.setRight(this.createRightPane());
      rootNode.setCenter(this.createCenterPane());
      rootNode.setBottom(this.createBottomPane());
      // padding between the panes and the window
      rootNode.setPadding(new Insets(30));
    } catch (Exception e) {
      System.out.println("An error occurred: " + e.getMessage());
    }

    return rootNode;
  }

  /**
   * Creates the right pane which will contain the buttons for dealing and checking the hand.
   *
   * @return The right pane.
   */
  private VBox createRightPane() {
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
    // sets the padding of the buttons
    rightPane.setPadding(new Insets(10));
    // sets the alignment of the buttons to be at the center
    rightPane.setAlignment(Pos.CENTER);

    return rightPane;
  }

  /**
   * Creates the center pane which will contain the main content.
   *
   * @return The center pane.
   */
  private FlowPane createCenterPane() {
    FlowPane centerPane = new FlowPane();

    centerPane.setAlignment(Pos.CENTER);
    Text handLabel = new Text("Deal a hand to see the cards.");
    handLabel.setStyle("-fx-fill: white;");
    this.handView = new FlowPane(handLabel);
    this.handView.setAlignment(Pos.CENTER);
    this.handView.setHgap(10);
    centerPane.setHgap(10);
    centerPane.getChildren().add(this.handView);
    centerPane.getStyleClass().add("center-pane");

    return centerPane;
  }

  /**
   * Creates the bottom pane which will contain the labels for the sum of face values, cards of
   * hearts, flush, and queen of spades.
   */
  private GridPane createBottomPane() {
    GridPane bottomPane = new GridPane();

    bottomPane.setAlignment(Pos.CENTER);
    bottomPane.setPadding(new Insets(10));
    bottomPane.setHgap(40);
    bottomPane.getStyleClass().add("bottom-pane");

    this.sumOfFacesLabel = new Label("Sum of face values: -");
    bottomPane.add(this.sumOfFacesLabel, 0, 0);
    this.cardsOfHeartsLabel = new Label("Cards of hearts: -");
    bottomPane.add(this.cardsOfHeartsLabel, 0, 1);
    this.flushLabel = new Label("Flush: Yes/No");
    bottomPane.add(this.flushLabel, 1, 0);
    this.queenOfSpadesLabel = new Label("Queen of spades: Yes/No");
    bottomPane.add(this.queenOfSpadesLabel, 1, 1);

    return bottomPane;
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
   * Sets the hand of cards and displays them as images.
   *
   * @param hand The hand of cards.
   */
  public void setHand(PlayingCard[] hand) {
    if (hand.length != 5) {
      throw new IllegalArgumentException("The hand must contain exactly 5 cards.");
    }

    // clears the hand view
    this.handView.getChildren().clear();

    // creates a new hand of cards
    this.hand = new HandOfCards(hand);

    // creates the images of each card
    Image card1 = new Image("cards/" + this.hand.getHand()[0].getAsString() + ".png");
    ImageView cardView1 = new ImageView(card1);
    cardView1.setFitHeight(100);
    cardView1.setPreserveRatio(true);
    Image card2 = new Image("cards/" + this.hand.getHand()[1].getAsString() + ".png");
    ImageView cardView2 = new ImageView(card2);
    cardView2.setFitHeight(100);
    cardView2.setPreserveRatio(true);
    Image card3 = new Image("cards/" + this.hand.getHand()[2].getAsString() + ".png");
    ImageView cardView3 = new ImageView(card3);
    cardView3.setFitHeight(100);
    cardView3.setPreserveRatio(true);
    Image card4 = new Image("cards/" + this.hand.getHand()[3].getAsString() + ".png");
    ImageView cardView4 = new ImageView(card4);
    cardView4.setFitHeight(100);
    cardView4.setPreserveRatio(true);
    Image card5 = new Image("cards/" + this.hand.getHand()[4].getAsString() + ".png");
    ImageView cardView5 = new ImageView(card5);
    cardView5.setFitHeight(100);
    cardView5.setPreserveRatio(true);

    // adds the image views to the hand view
    this.handView.getChildren().addAll(cardView1, cardView2, cardView3, cardView4, cardView5);
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
    this.handView.getChildren().clear();
    Text errorMessage = new Text("You must deal a hand before checking it.");
    errorMessage.setStyle("-fx-fill: white;");
    this.handView.getChildren().add(errorMessage);
  }
}
