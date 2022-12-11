module com.example.mystere {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mystere to javafx.fxml;
    exports com.example.mystere;
}