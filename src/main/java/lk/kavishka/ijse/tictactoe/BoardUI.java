package lk.kavishka.ijse.tictactoe;

public interface BoardUI {
    void update(int row, int col, Boolean isHuman);

    void notifyWinner();

}

