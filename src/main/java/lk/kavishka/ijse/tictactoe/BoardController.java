package lk.kavishka.ijse.tictactoe;

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
    private GridPane mainGrid;

    private String currentPlayer = "X";  // To track whether X or O is selected

    // Images for X and O
    private final Image crossMark = new Image(getClass().getResourceAsStream("/images/crossMark.png"));
    private final Image circleMark = new Image(getClass().getResourceAsStream("/images/circleMark.png"));

    // Event handler methods for cell clicks
    @FXML
    void cell1Click(MouseEvent event) {
        handleCellClick(cell1);
    }

    @FXML
    void cell2Click(MouseEvent event) {
        handleCellClick(cell2);
    }

    @FXML
    void cell3Click(MouseEvent event) {
        handleCellClick(cell3);
    }

    @FXML
    void cell4Click(MouseEvent event) {
        handleCellClick(cell4);
    }

    @FXML
    void cell5Click(MouseEvent event) {
        handleCellClick(cell5);
    }

    @FXML
    void cell6Click(MouseEvent event) {
        handleCellClick(cell6);
    }

    @FXML
    void cell7Click(MouseEvent event) {
        handleCellClick(cell7);
    }

    @FXML
    void cell8Click(MouseEvent event) {
        handleCellClick(cell8);
    }

    @FXML
    void cell9Click(MouseEvent event) {
        handleCellClick(cell9);
    }

    // Helper method to handle a cell click
    private void handleCellClick(Label cell) {
        if (cell.getGraphic() == null) {  // Only set if the cell is empty
            ImageView imageView = new ImageView(currentPlayer.equals("X") ? crossMark : circleMark);
            imageView.setFitWidth(50);  // Adjust the size as needed
            imageView.setFitHeight(50);
            cell.setGraphic(imageView);
        }
    }

    @Override
    public void initializeBoard() {
        // Initialization logic if needed
    }

    @Override
    public boolean isLegalMove(int row, int col) {
        // Add logic to check if a move is legal (e.g., if the cell is empty)
        return false;
    }

    @Override
    public void updateMove(int row, int col, Piece piece) {
        // Logic to update the board state
    }

    @Override
    public Piece checkWinner() {
        // Logic to check for a winner
        return null;
    }

    // Method to select X
    public void selectX(ActionEvent actionEvent) {
        currentPlayer = "X";
    }

    // Method to select O
    public void selectO(ActionEvent actionEvent) {
        currentPlayer = "O";
    }
}
