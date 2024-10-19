package lk.kavishka.ijse.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AIPlayer extends Player {
    private String aiMark;

    public AIPlayer(String aiMark, Board board) {
        super(board);
        this.aiMark = aiMark;
    }

    @Override
    public void move(int row, int col) {
        List<int[]> availableMoves = getAvailableMoves();

        if (!availableMoves.isEmpty()) {
            Random random = new Random();
            int[] move = availableMoves.get(random.nextInt(availableMoves.size()));

            // AI makes a random move
            board.updateMove(move[0], move[1], aiMark.equals("X") ? Piece.X : Piece.O);
        }
    }

    // Returns a list of available moves for the AI
    private List<int[]> getAvailableMoves() {
        List<int[]> moves = new ArrayList<>();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board.isLegalMove(row, col)) {
                    moves.add(new int[]{row, col});
                }
            }
        }
        return moves;
    }
}
