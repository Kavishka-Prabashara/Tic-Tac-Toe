package lk.kavishka.ijse.tictactoe;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomePage {

    public AnchorPane mainAnchorPane;
    @FXML
    private JFXButton btnEnter;

    @FXML
    private TextField txtName;

    private String playerName;
    private String currentPlayer = "X";

    private HumanPlayer humanPlayer;
    private AIPlayer aiPlayer;
    private Board board;  // Initialize the board

    public WelcomePage() {
        // Initialize the board instance here (or through other means)
        board = new BoardImpl(); // Assuming BoardImpl is your implementation of Board
    }

    @FXML
    public void selectX(ActionEvent actionEvent) {
        currentPlayer = "X";
        humanPlayer = new HumanPlayer("X", board);  // Pass the board instead of `this`
        aiPlayer = new AIPlayer("O", board);        // Pass the board instead of `this`
    }

    @FXML
    public void selectO(ActionEvent actionEvent) {
        currentPlayer = "O";
        humanPlayer = new HumanPlayer("O", board);  // Pass the board instead of `this`
        aiPlayer = new AIPlayer("X", board);        // Pass the board instead of `this`

        // AI should make the first move if player selects "O"
        aiPlayer.move(0, 0); // AI makes a move
    }

    @FXML
    void enterOnAction(ActionEvent event) {
        try {
            // Call the method to get the name when button is clicked
            playerName = getNameFromTextField();
           /* System.out.println("Player Name: " + playerName);
            System.out.println("Current Player: " + currentPlayer);*/

            // Load the main-window.fxml file
            FXMLLoader fxmlLoader = new FXMLLoader(AppInitializer.class.getResource("/view/main-window.fxml"));

            // Load the scene and get the BoardController
            Scene scene = new Scene(fxmlLoader.load());
            BoardController boardController = fxmlLoader.getController();

            // Pass player details to the BoardController
            boardController.initializeGame(playerName, currentPlayer);

            // Get the current stage from the event (button click)
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Set the scene and title for the main window
            stage.setTitle("Tic-Tac-Toe");
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace(); // Handle exceptions when loading the FXML file
        }
    }

    // Method to get the name from the TextField
    public String getNameFromTextField() {
        return txtName.getText(); // Return the text from the TextField
    }
}
