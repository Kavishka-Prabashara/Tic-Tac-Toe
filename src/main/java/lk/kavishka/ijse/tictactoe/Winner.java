package lk.kavishka.ijse.tictactoe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Winner {

    private Piece winningPiece;
    private int col1, row1, col2, row2, col3, row3;

}
