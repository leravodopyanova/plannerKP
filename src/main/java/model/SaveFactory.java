package model;

import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

public class SaveFactory {
    private Alert alert;

    public SaveSettings ChooseSaveMethod(String direction, String filename, String extension, ObservableList<tableViewPlan> tblViewPlans){
        if(extension.equals(".png")){
            return new SavePng(direction, filename, extension);
        }
        else if(extension.equals(".dat")){
            return new SaveDat(direction, filename, extension, tblViewPlans);
        }
        else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Сохранение файла");
            alert.setHeaderText("Внимание!");
            alert.setContentText("Выберите расширение!");
            alert.showAndWait();
            return null;
        }
    }
}
