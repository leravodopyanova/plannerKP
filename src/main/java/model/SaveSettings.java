package model;

import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public abstract class SaveSettings {
    private Alert alert;
    private Stage stage;
    protected DirectoryChooser directoryChooser;
    protected File selectedDirectory;
    protected String saveDir = "";

    public abstract void saveToFile(Node node, SnapshotParameters ssp) throws IOException;
    public void chooseSaveDir(){
       alert = new Alert(Alert.AlertType.INFORMATION);
       stage = new Stage();
       directoryChooser = new DirectoryChooser();

       alert.setTitle("Путь для сохранения файлов");
       alert.setHeaderText("Внимание!");

       directoryChooser.setTitle("Выберите каталог для сохранения");
       selectedDirectory = directoryChooser.showDialog(stage);

       if (selectedDirectory != null) {
           saveDir = selectedDirectory.getAbsolutePath();
       }

       alert.setContentText("Для сохранения выбран путь " + saveDir + "\nЕсли хотите изменить путь, перезапустите программу.");
       alert.showAndWait();
    }
}
