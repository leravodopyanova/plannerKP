module com.example.planner {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.swing;
    requires java.desktop;

    opens model to javafx.base;
    opens com.example.view to javafx.fxml;
    exports com.example.view;
}