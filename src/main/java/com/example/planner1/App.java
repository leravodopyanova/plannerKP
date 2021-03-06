package com.example.planner1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;

/**
 * Класс, запускающий окно выполнения программы.
 * @author Водопьянова Валерия
 * @version 1.1
 */

public class App extends Application {
    /**
     * Этот метод запускает окно выполнения программы.
     * @param stage the primary stage for this application, onto which
     * the application scene can be set.
     * Applications may create other stages, if needed, but they will not be
     * primary stages.
     * @throws IOException
     * @see IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("WorkPlaceStudent.fxml"));
        //FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("WorkPlacemathodist.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}