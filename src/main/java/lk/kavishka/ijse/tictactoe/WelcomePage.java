package lk.kavishka.ijse.tictactoe;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class WelcomePage {

    @FXML
    private JFXButton btnEnter;

    @FXML
    private TextField txtName;

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
        // Call the method to get the name when button is clicked
        String playerName = getNameFromTextField();
        System.out.println("Player Name: " + playerName);
        System.out.println("Current Player: " + currentPlayer);
        // You can now use the playerName for other logic, such as passing it to another class
    }

    // Method to get the name from the TextField
    public String getNameFromTextField() {
        return txtName.getText(); // Return the text from the TextField
    }
}
