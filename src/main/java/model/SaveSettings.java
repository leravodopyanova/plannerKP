package model;

import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

/**
 * Класс, реализующий настройку работы с сохранением данных.
 * @author Водопьянова Валерия
 * @version 1.1
 */
public abstract class SaveSettings {
    private Alert alert;
    private Stage stage;
    protected DirectoryChooser directoryChooser;
    protected File selectedDirectory;
    protected String saveDir = "C:\\";

    /**
     * Этот абстрактный метод задает реализацию сохрания файла.
     * @param node Параметр нода графического объекта сцены.
     * @param ssp Параметр для выполнения рендеринга изображений.
     * @throws IOException
     * @see IOException
     * @see Node
     * @see SnapshotParameters
     */
    public abstract void saveToFile(Node node, SnapshotParameters ssp) throws IOException;

    /**
     * Конструктор класса без параметра.
     */
    public SaveSettings(){

    }

    /**
     * Этот метод выводит диалоговое окно выбора директории для сохранения.
     * Сохраняет директорию для сохранения.
     */
    public void chooseSaveDir(){
       alert = new Alert(Alert.AlertType.INFORMATION);
       stage = new Stage();
       directoryChooser = new DirectoryChooser();

       alert.setTitle("Путь для сохранения файлов");
       alert.setHeaderText("Внимание!");

       directoryChooser.setTitle("Выберите каталог для сохранения");
       selectedDirectory = directoryChooser.showDialog(stage);

       if (selectedDirectory != null) {
           this.saveDir = selectedDirectory.getAbsolutePath();
           System.out.println(this.saveDir);
       }

       alert.setContentText("Для сохранения выбран путь " + saveDir + "\nЕсли хотите изменить путь, перезапустите программу.");
       alert.showAndWait();
    }

    /**
     * Этот метод получает директорию, выбранную для сохранения.
     * @return Значение директории для сохранения.
     */
    public String getSaveDir(){
        return saveDir;
    }
}
