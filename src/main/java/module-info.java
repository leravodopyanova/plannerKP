module com.example.planner1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.planner1 to javafx.fxml;
    exports com.example.planner1;
}