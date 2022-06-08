package model;

import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;

import java.io.*;

public class SaveDat extends SaveSettings {
    private String fileName;
    private String extension;
    private File file;
    private Alert alert;
    private Object object;

    public SaveDat(String fileName, String extension, Object object){
        this.fileName = fileName;
        this.extension = extension;
        this.object = object;
    }
    public String getFullPath(){
        return saveDir + this.fileName + this.extension;
    }

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
    public Object openDatFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(getFullPath())))
        {
            object= ois.readObject();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return object;
    }
}
