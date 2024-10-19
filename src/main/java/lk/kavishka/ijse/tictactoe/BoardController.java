package lk.kavishka.ijse.tictactoe;

import javafx.scene.control.Alert;
import lk.kavishka.ijse.tictactoe.HumanPlayer;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class BoardController implements Board {

    @FXML
    private Label cell1, cell2, cell3, cell4, cell5, cell6, cell7, cell8, cell9;

    @FXML
    private AnchorPane mainAnchorPane, titleBar;

    @FXML
    private JFXButton resetBtn, Xbtn, Obtn;

    @FXML
    private GridPane mainGrid;

    private String currentPlayer = "X";
    private boolean gameWon = false;
    private String[][] boardState = new String[3][3]; // "X", "O", or null

    private Player humanPlayer;
    private AIPlayer aiPlayer;

    // Image resources for X and O
    private final Image crossMark = new Image(getClass().getResourceAsStream("/images/crossMark.png"));
    private final Image circleMark = new Image(getClass().getResourceAsStream("/images/circleMark.png"));

    @FXML
    public void initialize() {
        initializeBoard();
    }

    // User chooses to play as "X"
    @FXML
    public void selectX(ActionEvent actionEvent) {
        currentPlayer = "X";
        humanPlayer = new HumanPlayer("X", this);
        aiPlayer = new AIPlayer("O", this);
    }

    // User chooses to play as "O" and AI goes first
    @FXML
    public void selectO(ActionEvent actionEvent) {
        currentPlayer = "O";
        humanPlayer = new HumanPlayer("O", this);
        aiPlayer = new AIPlayer("X", this);

        // AI should make the first move if player selects "O"
        aiPlayer.move(0, 0); // AI makes a move
        updateBoardUI();      // Update the UI to reflect AI's move
    }

    @FXML
    void cell1Click(MouseEvent event) {
        handleCellClick(cell1, 0, 0);
    }

    @FXML
    void cell2Click(MouseEvent event) {
        handleCellClick(cell2, 0, 1);
    }

    @FXML
    void cell3Click(MouseEvent event) {
        handleCellClick(cell3, 0, 2);
    }

    @FXML
    void cell4Click(MouseEvent event) {
        handleCellClick(cell4, 1, 0);
    }

    @FXML
    void cell5Click(MouseEvent event) {
        handleCellClick(cell5, 1, 1);
    }

    @FXML
    void cell6Click(MouseEvent event) {
        handleCellClick(cell6, 1, 2);
    }

    @FXML
    void cell7Click(MouseEvent event) {
        handleCellClick(cell7, 2, 0);
    }

    @FXML
    void cell8Click(MouseEvent event) {
        handleCellClick(cell8, 2, 1);
    }

    @FXML
    void cell9Click(MouseEvent event) {
        handleCellClick(cell9, 2, 2);
    }

    private void handleCellClick(Label cell, int row, int col) {
        if (humanPlayer == null || aiPlayer == null) {
            // Show alert if the player hasn't selected X or O
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Selection Required");
            alert.setHeaderText(null);
            alert.setContentText("Please select X or O before playing.");

            // Display the alert
            alert.showAndWait();
            return; // Exit the method to prevent further processing
        }

        if (gameWon || boardState[row][col] != null) {
            return; // Ignore clicks after game is won or if cell is already occupied
        }

        // Human player makes their move
        humanPlayer.move(row, col);
        updateCellGraphic(cell, currentPlayer);

        if (checkWinner()) {
            // Create a "You Win!" alert
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Game Over");
            alert.setHeaderText(null);
            alert.setContentText("You Win! :-)");
            alert.showAndWait();
            gameWon = true;
        } else {
            // If no winner, AI makes a move
            aiPlayer.move(0, 0);
            updateBoardUI();

            if (checkWinner()) {
                // Create an "AI Wins!" alert
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Game Over");
                alert.setHeaderText(null);
                alert.setContentText("AI Wins! :-(");
                alert.showAndWait();
                gameWon = true;
            }
        }
    }

    // Updates the graphical representation of the board
    private void updateBoardUI() {
        Label[] cells = {cell1, cell2, cell3, cell4, cell5, cell6, cell7, cell8, cell9};
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                String value = boardState[row][col];
                if (value != null) {
                    ImageView imageView = new ImageView(value.equals("X") ? crossMark : circleMark);
                    imageView.setFitWidth(50);
                    imageView.setFitHeight(50);
                    cells[row * 3 + col].setGraphic(imageView);
                }
            }
        }
    }

    // Updates the UI for a single cell when the player makes a move
    private void updateCellGraphic(Label cell, String mark) {
        ImageView imageView = new ImageView(mark.equals("X") ? crossMark : circleMark);
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        cell.setGraphic(imageView);
    }

    @Override
    public BoardUI getBoardUI() {
        return null;
    }

    @Override
    public void initializeBoard() {
        boardState = new String[3][3]; // Reset the board state
        cell1.setGraphic(null);
        cell2.setGraphic(null);
        cell3.setGraphic(null);
        cell4.setGraphic(null);
        cell5.setGraphic(null);
        cell6.setGraphic(null);
        cell7.setGraphic(null);
        cell8.setGraphic(null);
        cell9.setGraphic(null);
        currentPlayer = "X";
        gameWon = false;
    }

    @Override
    public boolean isLegalMove(int row, int col) {
        return boardState[row][col] == null; // A move is legal if the cell is empty
    }

    @Override
    public void updateMove(int row, int col, Piece piece) {
        boardState[row][col] = piece.name(); // Update the board state
    }

    @Override
    public boolean checkWinner() {
        // Define winning conditions for rows, columns, and diagonals
        String[][] lines = {
                {boardState[0][0], boardState[0][1], boardState[0][2]}, // Row 1
                {boardState[1][0], boardState[1][1], boardState[1][2]}, // Row 2
                {boardState[2][0], boardState[2][1], boardState[2][2]}, // Row 3
                {boardState[0][0], boardState[1][0], boardState[2][0]}, // Col 1
                {boardState[0][1], boardState[1][1], boardState[2][1]}, // Col 2
                {boardState[0][2], boardState[1][2], boardState[2][2]}, // Col 3
                {boardState[0][0], boardState[1][1], boardState[2][2]}, // Diagonal 1
                {boardState[0][2], boardState[1][1], boardState[2][0]}  // Diagonal 2
        };

        for (String[] line : lines) {
            if (line[0] != null && line[0].equals(line[1]) && line[1].equals(line[2])) {
                return true; // A line with three equal non-null marks means we have a winner
            }
        }
        return false; // No winner found
    }

    @Override
    public void printBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print((boardState[row][col] != null ? boardState[row][col] : "-") + " ");
            }
            System.out.println();
        }
    }

    @Override
    public AIPlayer getAIPlayer() {
        return aiPlayer;
    }

    public void resetField(ActionEvent actionEvent) {
    }
}
