package lk.kavishka.ijse.tictactoe;

public abstract class Player {
    protected Board board;

    public Player(Board board) {
        this.board = board;
    }

    // Abstract method to be implemented by concrete player types
    public abstract void move(int row, int col);
}
