module com.example.mavenproject1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;
    requires java.desktop;
    requires java.logging;

    opens com.example.mavenproject1 to javafx.fxml;
    exports com.example.mavenproject1;
}
