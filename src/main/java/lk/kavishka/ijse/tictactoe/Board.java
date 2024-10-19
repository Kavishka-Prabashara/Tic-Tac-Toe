package lk.kavishka.ijse.tictactoe;

public interface Board {

    // Method to initialize the game board
    void initializeBoard();

    // Method to check if a move is legal
    boolean isLegalMove(int row, int col);

    // Method to update the board with the player's move
    void updateMove(int row, int col, Piece piece);

    // Method to check if there's a winner

    BoardUI getBoardUI();

    boolean checkWinner();

    void printBoard();

    Object getAIPlayer();
}
