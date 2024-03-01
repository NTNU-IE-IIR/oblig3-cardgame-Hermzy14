package no.ntnu.idatx2003.oblig3.cardgame;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Represents the graphical user interface for the card game.
 */
public class CardGameUi extends Application {
  /**
   * Constructs the main window.
   *
   * @param stage The main window.
   */
  @Override
  public void start(Stage stage) {
    // creates the layout
    BorderPane rootNode = this.createLayout();

    // creates a scene
    Scene scene = new Scene(rootNode, 600, 400);
    // gets a style sheet
    scene.getStylesheets().add("styles.css");
    // sets the scene
    stage.setScene(scene);
    stage.setTitle("Card Game");
    stage.show();
  }

  /**
   * Creates the layout of the main window.
   */
  private BorderPane createLayout() {
    BorderPane rootNode = new BorderPane();

    rootNode.setRight(this.createRightPane());
    rootNode.setCenter(this.createCenterPane());
    rootNode.setBottom(this.createBottomPane());

    rootNode.setPadding(new Insets(30));

    return rootNode;
  }

  /**
   * Creates the right pane of the main window.
   *
   * @return The right pane.
   */
  private VBox createRightPane() {
    // creates buttons
    Button dealHandButton = new Button("Deal hand");
    Button checkHandButton = new Button("Check hand");
    // adds a style class to the buttons
    dealHandButton.getStyleClass().add("button");
    checkHandButton.getStyleClass().add("button");
    // creates a vertical box
    VBox rightPane = new VBox();
    // adds the buttons to the vertical box
    rightPane.getChildren().addAll(dealHandButton, checkHandButton);
    rightPane.setSpacing(10);
    rightPane.setAlignment(Pos.CENTER);

    return rightPane;
  }

  /**
   * Creates the center pane of the main window.
   * TODO: Replace this with a pane that displays all the cards in the hand of the player.
   *
   * @return The center pane.
   */
  private Text createCenterPane() {
    // displays a text of a card
    Text text = new Text(new PlayingCard('H', 1).getAsString());
    text.setStyle("-fx-font-size: 24");

    return text;
  }

  /**
   * Creates the bottom pane of the main window.
   *
   * @return The bottom pane.
   */
  private HBox createBottomPane() {
    // creates a horizontal box which holds sum of the faces
    HBox sumPane = new HBox();
    Text sumText = new Text("Sum of faces: ");
    Text sumValue = new Text("0"); // TODO: Bind this to the actual sum of the faces dealt
    sumPane.getChildren().addAll(sumText, sumValue);

    // creates a horizontal box
    HBox bottomPane = new HBox();
    // adds the sum pane to the horizontal box
    bottomPane.getChildren().add(sumPane);

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
}
