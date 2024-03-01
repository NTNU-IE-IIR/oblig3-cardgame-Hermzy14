package no.ntnu.idatx2003.oblig3.cardgame;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
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
  private FlowPane createBottomPane() {
    // creates a sum pane
    HBox sumPane = this.createSumPane();
    // creates a heart pane
    HBox heartPane = this.createHeartPane();
    // creates a flush pane
    HBox flushPane = this.createFlushPane();
    // creates a queen of spades pane
    HBox queenOfSpadesPane = this.createQueenOfSpadesPane();

    // creates a horizontal box
    FlowPane bottomPane = new FlowPane();
    // adds all the bottom panes to the horizontal box
    bottomPane.getChildren().addAll(sumPane, heartPane, flushPane, queenOfSpadesPane);
    // sets the spacing between the panes
    bottomPane.setHgap(20);

    return bottomPane;
  }

  /**
   * Displays the sum of the faces of the cards in the hand.
   * TODO: Bind this to the actual sum of the faces dealt
   *
   * @return The sum of the faces of the cards in the hand.
   */
  private HBox createSumPane() {
    HBox sumPane = new HBox();

    Text sumText = new Text("Sum of faces: ");
    Text sumValue = new Text("0");

    sumPane.getChildren().addAll(sumText, sumValue);
    sumPane.getStyleClass().add("bottom-pane-child");

    return sumPane;
  }

  /**
   * Displays only the cards in the hand that are of the suit hearts.
   * TODO: Replace this with a pane that displays the heart-card in the hand.
   *
   * @return The pane that displays the heart-cards in the hand.
   */
  private HBox createHeartPane() {
    HBox heartPane = new HBox();

    Text heartText = new Text("Cards of hearts: ");
    Text heartCards = new Text("H12, H1");

    heartPane.getChildren().addAll(heartText, heartCards);
    heartPane.getStyleClass().add("bottom-pane-child");

    return heartPane;
  }

  /**
   * Displays whether the hand is a flush or not.
   * TODO: Bind this to the actual hand dealt.
   *
   * @return The pane that displays whether the hand is a flush or not.
   */
  private HBox createFlushPane() {
    HBox flushPane = new HBox();

    Text flushText = new Text("Flush: ");
    Text flushValue = new Text("Yes/No");

    flushPane.getChildren().addAll(flushText, flushValue);
    flushPane.getStyleClass().add("bottom-pane-child");

    return flushPane;
  }

  /**
   * Displays whether the hand contains the queen of spades or not.
   * TODO: Bind this to the actual hand dealt.
   *
   * @return The pane that displays whether the hand contains the queen of spades or not.
   */
  private HBox createQueenOfSpadesPane() {
    HBox queenOfSpadesPane = new HBox();

    Text queenOfSpadesText = new Text("Queen of spades: ");
    Text queenOfSpadesValue = new Text("Yes/No");

    queenOfSpadesPane.getChildren().addAll(queenOfSpadesText, queenOfSpadesValue);
    queenOfSpadesPane.getStyleClass().add("bottom-pane-child");

    return queenOfSpadesPane;
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
