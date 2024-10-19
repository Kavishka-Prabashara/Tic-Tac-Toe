package lk.kavishka.ijse.tictactoe;

public class HumanPlayer extends Player {
    private String humanMark;

    public HumanPlayer(String humanMark, Board board) {
        super(board);
        this.humanMark = humanMark;
    }

    @Override
    public void move(int row, int col) {
        if (board.isLegalMove(row, col)) {
            board.updateMove(row, col, humanMark.equals("X") ? Piece.X : Piece.O);
        }
    }
}
