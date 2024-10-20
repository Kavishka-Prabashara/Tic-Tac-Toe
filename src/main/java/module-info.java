module lk.kavishka.ijse.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires static lombok;


    opens lk.kavishka.ijse.tictactoe to javafx.fxml;
    exports lk.kavishka.ijse.tictactoe;
}

