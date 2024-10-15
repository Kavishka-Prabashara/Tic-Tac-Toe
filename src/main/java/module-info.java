module lk.kavishka.ijse.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;


    opens lk.kavishka.ijse.tictactoe to javafx.fxml;
    exports lk.kavishka.ijse.tictactoe;
}