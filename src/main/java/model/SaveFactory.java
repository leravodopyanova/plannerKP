package model;

import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

/**
 * Класс, реализующий фабричный метод выбора способа сохранения данных.
 * @author Водопьянова Валерия
 * @version 1.1
 */
public class SaveFactory {
    private Alert alert;

    /**
     * Этот метод осуществляет выбор метода сохранения данных, в зависимости от полученного
     * от пользователя параметра расширения файла extension.
     * @param direction Параметр пути для сохранения файла.
     * @param filename Параметр имени сохраняемого файла.
     * @param extension Параметр расширения сохраняемого файла.
     * @param tblViewPlans Параметр модели табличных данных.
     * @return Объект, реализующий способ сохранения данных.
     */
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
