package no.ntnu.idatx2003.oblig3.cardgame;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
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

    this.sumOfFacesLabel = new Label("Sum of face values: "); //TODO: add the sum of the face values of the cards in the hand
    bottomPane.add(this.sumOfFacesLabel, 0, 0);
    this.cardsOfHeartsLabel = new Label("Cards of hearts: "); //TODO: add the cards of hearts in the hand
    bottomPane.add(this.cardsOfHeartsLabel, 0, 1);
    this.flushLabel = new Label("Flush: "); //TODO: add if the hand is a flush
    bottomPane.add(this.flushLabel, 1, 0);
    this.queenOfSpadesLabel = new Label("Queen of spades: "); //TODO: add if the hand contains the queen of spades
    bottomPane.add(this.queenOfSpadesLabel, 1, 1);

    // CENTER PANE
    FlowPane centerPane = new FlowPane();
    this.handLabel = new Label("You have not been dealt a hand yet.\n" +
        " Click the 'Deal hand' button to deal a hand of cards.");
    centerPane.setAlignment(Pos.CENTER);
    centerPane.setHgap(10);
    centerPane.getChildren().add(this.handLabel);

    // adds the panes to the layout
    rootNode.setRight(rightPane);
    rootNode.setCenter(centerPane);
    rootNode.setBottom(bottomPane);

    rootNode.setPadding(new Insets(30));

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

  public void setHand(PlayingCard[] hand) { //TODO: add images of the cards
    this.hand = new HandOfCards(hand);
    this.handLabel.setText(
        this.hand.getHand()[0].getAsString() + ", " +
      this.hand.getHand()[1].getAsString() + ", " +
      this.hand.getHand()[2].getAsString() + ", " +
      this.hand.getHand()[3].getAsString() + ", " +
      this.hand.getHand()[4].getAsString()
    );
  }
}
