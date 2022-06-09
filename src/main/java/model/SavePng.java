package model;

import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;
import javafx.scene.image.WritableImage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

import static javafx.embed.swing.SwingFXUtils.fromFXImage;

public class SavePng extends SaveSettings {
    private String fileName;
    private String extension;
    private File file;
    private Alert alert;
    private WritableImage image;
    private String saveDirection = "C:";

    public SavePng(String saveDirection, String fileName, String extension){
        this.saveDirection = saveDirection;
        this.fileName = fileName;
        this.extension = extension;
    }
    public String getFullPath(){
        return this.saveDirection + "\\" + this.fileName + this.extension;
    }

    @Override
    public void saveToFile(Node node, SnapshotParameters ssp) {
        image = node.snapshot(ssp, null);
        file = new File(getFullPath());
        try {
            ImageIO.write(fromFXImage(image, null), "png", file);
        } catch (IOException e) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Сохранение файла");
            alert.setHeaderText("Внимание!");
            alert.setContentText("Не удалось сохранить файл!");
            alert.showAndWait();
        }
    }
}
