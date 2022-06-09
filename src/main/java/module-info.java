module com.example.planner1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.swing;
    requires java.desktop;

    opens model to javafx.base;
    opens com.example.planner1 to javafx.fxml;
    exports com.example.planner1;
}