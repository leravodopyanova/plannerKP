package model;

import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;
import javafx.scene.image.WritableImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import static javafx.embed.swing.SwingFXUtils.fromFXImage;

/**
 * Класс, реализующий сохранение данных в формате .dat.
 * @author Водопьянова Валерия
 * @version 1.1
 */
public class SavePng extends SaveSettings {
    private String fileName;
    private String extension;
    private File file;
    private Alert alert;
    private WritableImage image;
    private String saveDirection = "C:";

    /**
     * Конструктор класса с параметрами для получения пути к файлу и объекта для сохранения.
     * @param saveDirection Параметр директории для сохранений.
     * @param fileName Параметр названия файла.
     * @param extension Параметр расширения файла.
     */
    public SavePng(String saveDirection, String fileName, String extension){
        this.saveDirection = saveDirection;
        this.fileName = fileName;
        this.extension = extension;
    }
    /**
     * Этот метод создает полную строку пути файла.
     * @return Значение пути к файлу.
     */
    public String getFullPath(){
        return this.saveDirection + "\\" + this.fileName + this.extension;
    }

    /**
     * Этот метод реализует сохранения файла в виде скриншота диаграммы Ганта (.png).
     * @param node Параметр нода графического объекта сцены.
     * @param ssp Параметр для выполнения рендеринга изображений.
     */
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
