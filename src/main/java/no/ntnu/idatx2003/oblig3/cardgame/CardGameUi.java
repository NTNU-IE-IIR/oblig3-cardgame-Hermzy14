package no.ntnu.idatx2003.oblig3.cardgame;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
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
    Button dealHandButton = new Button("Deal hand");
    Button checkHandButton = new Button("Check hand");
    dealHandButton.getStyleClass().add("button");
    checkHandButton.getStyleClass().add("button");
    VBox rightPane = new VBox();
    rightPane.getChildren().addAll(dealHandButton, checkHandButton);
    rightPane.setSpacing(10);
    rightPane.setAlignment(Pos.CENTER);

    // displays a text of a card
    Text text = new Text(new PlayingCard('H', 1).getAsString());
    text.setStyle("-fx-font-size: 24");

    BorderPane rootNode = new BorderPane();

    rootNode.setRight(rightPane);
    rootNode.setCenter(text);

    rootNode.setPadding(new Insets(30));

    // creates a scene
    Scene scene = new Scene(rootNode);
    // gets a style sheet
    scene.getStylesheets().add("styles.css");
    // sets the scene
    stage.setScene(scene);
    stage.setTitle("Card Game");
    stage.show();
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
