module com.example.imageeditor {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.swing;
     requires javafx.graphics;




    opens com.example.imageeditor to javafx.fxml;
    exports com.example.imageeditor;
}