package lk.kavishka.ijse.tictactoe;

public class BoardImpl implements Board {
    private String[][] boardState = new String[3][3]; // "X", "O", or null

    @Override
    public void initializeBoard() {
        boardState = new String[3][3]; // Reset the board state
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
    public Object getAIPlayer() {
        return null; // This implementation does not handle AI directly
    }

    @Override
    public BoardUI getBoardUI() {
        return null; // No UI in this implementation
    }
}
