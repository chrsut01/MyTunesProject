module com.example.mytunesproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.media;


    opens com.example.mytunesproject to javafx.fxml;
    exports com.example.mytunesproject;
}