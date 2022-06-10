package model;

import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * Класс, реализующий сохранение данных в формате .dat.
 * @author Водопьянова Валерия
 * @version 1.1
 */
public class SaveDat extends SaveSettings {
    private String fileName;
    private String extension;
    private File file;
    private Alert alert;
    private Object object;
    private String selectedDir = "C:";

    /**
     * Конструктор класса с параметрами для получения пути к файлу и объекта для сохранения.
     * @param selectedDir Параметр директории для сохранений.
     * @param fileName Параметр названия файла.
     * @param extension Параметр расширения файла.
     * @param object Параметр объекта для сохранения.
     */
    public SaveDat(String selectedDir, String fileName, String extension, Object object){
        this.selectedDir = selectedDir;
        this.fileName = fileName;
        this.extension = extension;
        this.object = object;
    }

    /**
     * Этот метод создает полную строку пути файла.
     * @return Значение пути к файлу.
     */
    public String getFullPath(){
        return selectedDir + "\\" + this.fileName + this.extension;
    }

    /**
     * Этот метод реализует сериализацию данных объекта.
     * @param node Параметр нода графического объекта сцены.
     * @param ssp Параметр для выполнения рендеринга изображений.
     */
    @Override
    public void saveToFile(Node node, SnapshotParameters ssp) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(getFullPath())))
        {
            oos.writeObject(object);
        }
        catch(Exception ex){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Сохранение файла");
            alert.setHeaderText("Внимание!");
            alert.setContentText("Не удалось сохранить файл!");
            alert.showAndWait();
        }
    }

    /**
     * Этот метод реализует десериализацию данных объекта.
     * @param node Параметр нода графического объекта сцены.
     * @param ssp Параметр для выполнения рендеринга изображений.
     */
    public void openDatFile(Node node, SnapshotParameters ssp) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(getFullPath())))
        {
            oos.writeObject(object);
        }
        catch(Exception ex){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Сохранение файла");
            alert.setHeaderText("Внимание!");
            alert.setContentText("Не удалось сохранить файл!");
            alert.showAndWait();
        }
    }
}
