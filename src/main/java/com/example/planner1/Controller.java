package com.example.planner1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import model.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.*;

public class Controller implements Initializable {
    public TextField tfDisciplineSt;
    public CheckBox chbIsDone;
    public Canvas canvas1;
    public GraphicsContext gr;
    public Canvas canvas2;
    public Canvas canvas3;
    public Canvas canvas4;
    public Canvas canvas5;
    public Canvas canvas6;
    public Canvas canvas7;
    public Label lblMonth;
    public Label lblWeekNom;
    public Button btnSave;
    public Button btnClear;
    public Button btnDiagram;
    public Button btnRight;
    public Button btnLeft;
    public Button toNext;
    public Label lblColorBlock;
    public GridPane gridPaneNode = new GridPane();
    private final ObservableList<String> extensions = FXCollections.observableArrayList("Excel", "PNG", "DAT");
    public ComboBox cmbTypeFile;
    public Button btnClose11;
    public Button btnClose111;
    public AnchorPane windowSt;
    private ObservableList<tableViewPlan> tableViewPlans = FXCollections.observableArrayList();;
    public TableView <tableViewPlan>tvTablePlans = new TableView<>();
    public TableColumn <tableViewPlan, Integer> colNo = new TableColumn<>();
    public TableColumn <tableViewPlan, LocalDate> colDate = new TableColumn<>();
    public TableColumn <tableViewPlan, String> colFrom = new TableColumn<>();
    public TableColumn <tableViewPlan, String> colTo = new TableColumn<>();
    public TableColumn <tableViewPlan, String> colDiscipl = new TableColumn<>();
    public TableColumn <tableViewPlan, String> colStatus = new TableColumn<>();
    public TableColumn <tableViewPlan, String> colComm = new TableColumn<>();
    public TableColumn<tableViewPlan, Color> colColor = new TableColumn<>();
    public TableColumn <tableViewPlan, Integer> colWeekNo = new TableColumn<>();
    private SnapshotParameters ssp;
    public DatePicker dpDate;
    public Button btnCloseSt;
    public Button btnCloseM;
    public TextField tfNameDiscipline;
    public TextField tfAcademicHours;
    public Button btnAddPlan;
    public Button btnDeletePlan;
    public Button btnSavePlan;
    public Button btnAddToPlanM;
    public ColorPicker cpBlockColor;
    public TextField tfFromTime;
    public TextField tfToTime;
    public TextArea taComment;
    public Button btnAddToPlanSt;
    public UserSettings userSettings;
    @FXML
    private TextField tfProjectNameSt;
    @FXML
    private TextField tfProjectNameM;
    private Calendar calendar = Calendar.getInstance();

    private LocalDate date;
    private Locale locale = Locale.ENGLISH;
    private GregorianCalendar gnow;
    private int countCol = 0;
    private int weekNo;
    private String filename = "C:\\Users\\Лера\\Downloads\\Книга1.xlsx";
    private CheckClass checkClass;
    private Rectan rectan;
    private Decorator decRectan;
    private String canvasDate = "";
    private Stage stage;
    private DirectoryChooser directoryChooser;
    private File selectedDirectory;
    private String saveDir = "C:\\";
    private HashMap<Canvas, String> canvasDateMap = new HashMap<>();
    private  HashMap<String, Date> weekDates = new HashMap<>();
    private Alert alertSaveDir;
    private boolean isEditStart = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gnow = new GregorianCalendar();
        checkClass = new CheckClass();
        userSettings = new UserSettings();

        decRectan = null;

        chooseSaveDir();
        setToolTips();

        cmbTypeFile.setItems(extensions);
        weekNo = LocalDateTime.now().get(WeekFields.of(locale).weekOfWeekBasedYear()) - 1;
        lblMonth.setText(userSettings.getLocaleMonth());
        lblWeekNom.setText("Неделя " + weekNo);
        ssp = new SnapshotParameters();

        // Для отображения стиля названия проекта
        tfProjectNameSt.setStyle("-fx-text-fill: #AFEEEE; -fx-background-color: rgba(0,0,0,0);");
        //  tfProjectNameM.setStyle("-fx-text-fill: #AFEEEE; -fx-background-color: rgba(0,0,0,0);");

        // Закрытие по кнопке
        btnCloseSt.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.exit(0);
            }
        });

       /* btnCloseM.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.exit(0);
            }
        });
        */

        // Заполнение tableView


        rectan = new Rectan(Color.TRANSPARENT, 10, 10, 0, 0);
        gr = canvas1.getGraphicsContext2D();


        // Разные цвета для полей диаграммы
        canvas2.getGraphicsContext2D().setFill(Color.LIGHTGOLDENRODYELLOW);
        canvas2.getGraphicsContext2D().fillRect(0, 0, canvas2.getWidth(), canvas2.getHeight());
        canvas4.getGraphicsContext2D().setFill(Color.LIGHTGOLDENRODYELLOW);
        canvas4.getGraphicsContext2D().fillRect(0, 0, canvas4.getWidth(), canvas4.getHeight());
        canvas6.getGraphicsContext2D().setFill(Color.LIGHTGOLDENRODYELLOW);
        canvas6.getGraphicsContext2D().fillRect(0, 0, canvas6.getWidth(), canvas6.getHeight());

        loadGanttDiagram();
    }

    public void btnAddToPlanM_OnAction(ActionEvent actionEvent) {

    }
    public void btnAddToPlanSt_OnAction(ActionEvent actionEvent) {
        colNo.setCellValueFactory(new PropertyValueFactory<tableViewPlan, Integer >("colNo"));
        colDate.setCellValueFactory(new PropertyValueFactory<tableViewPlan, LocalDate>("colDate"));
        colDiscipl.setCellValueFactory(new PropertyValueFactory<tableViewPlan, String>("colDiscipl"));
        colFrom.setCellValueFactory(new PropertyValueFactory<tableViewPlan, String>("colFrom"));
        colTo.setCellValueFactory(new PropertyValueFactory<tableViewPlan, String>("colTo"));
        colStatus.setCellValueFactory(new PropertyValueFactory<tableViewPlan, String>("colStatus"));
        colComm.setCellValueFactory(new PropertyValueFactory<tableViewPlan, String>("colComm"));
        colColor.setCellValueFactory(new PropertyValueFactory<tableViewPlan, Color>("colColor"));
        colWeekNo.setCellValueFactory(new PropertyValueFactory<tableViewPlan, Integer>("colWeekNo"));
        init_Data();

        tvTablePlans.setItems(tableViewPlans);
    }

    private void init_Data() {
        date = dpDate.getValue();
        weekNo = date.get(WeekFields.of(locale).weekOfWeekBasedYear());
        countCol++;
        tableViewPlans.add(new tableViewPlan(countCol, dpDate.getValue(),
                tfDisciplineSt.getText(), tfFromTime.getText(), tfToTime.getText(),
                checkClass.checkStatus(chbIsDone.isSelected()),
                taComment.getText(), cpBlockColor.getValue(), weekNo));
    }

    public void onCanva1_clicked(MouseEvent mouseEvent) {
        userSettings.CanvasClick(tfFromTime, tfToTime, canvas1, mouseEvent, rectan, weekDates, dpDate);
        isEditStart = true;
    }

    public void onCanva2_clicked(MouseEvent mouseEvent) {
        userSettings.CanvasClick(tfFromTime, tfToTime, canvas2, mouseEvent, rectan, weekDates, dpDate);
        isEditStart = true;
    }

    public void onCanva3_clicked(MouseEvent mouseEvent) {
        userSettings.CanvasClick(tfFromTime, tfToTime, canvas3, mouseEvent, rectan, weekDates, dpDate);
        isEditStart = true;
    }

    public void onCanva4_clicked(MouseEvent mouseEvent) {
        userSettings.CanvasClick(tfFromTime, tfToTime, canvas4, mouseEvent, rectan, weekDates, dpDate);
        isEditStart = true;
    }

    public void onCanva5_clicked(MouseEvent mouseEvent) {
        userSettings.CanvasClick(tfFromTime, tfToTime, canvas5, mouseEvent, rectan, weekDates, dpDate);
        isEditStart = true;
    }

    public void onCanva6_clicked(MouseEvent mouseEvent) {
        userSettings.CanvasClick(tfFromTime, tfToTime, canvas6, mouseEvent, rectan, weekDates, dpDate);
        isEditStart = true;
    }

    public void onCanva7_clicked(MouseEvent mouseEvent) {
        userSettings.CanvasClick(tfFromTime, tfToTime, canvas7, mouseEvent, rectan, weekDates, dpDate);
        isEditStart = true;
    }

    public String getDateString(){
        String dateStr = calendar.getTime().toString();
        dateStr = dateStr.substring(4, 11) + dateStr.substring((dateStr.length() - 4));
        return dateStr;
    }
    public void loadGanttDiagram(){
        canvasDateMap.clear();
        weekDates.clear();
        clearDiagram();

        lblWeekNom.setText("Неделя " + weekNo);

        calendar.setWeekDate(2022, weekNo, Calendar.MONDAY);
        calendar = calendar;
        setCanvasColor(canvas1);
        System.out.println(calendar.getTime());
        weekDates.put(canvas1.getId(), calendar.getTime());

        calendar.setWeekDate(2022, weekNo, Calendar.TUESDAY);
        calendar = calendar;
        setCanvasColor(canvas2);
        weekDates.put(canvas2.getId(), calendar.getTime());

        calendar.setWeekDate(2022, weekNo, Calendar.WEDNESDAY);
        calendar = calendar;
        setCanvasColor(canvas3);
        weekDates.put(canvas3.getId(), calendar.getTime());

        calendar.setWeekDate(2022, weekNo, Calendar.THURSDAY);
        calendar = calendar;
        setCanvasColor(canvas4);
        weekDates.put(canvas4.getId(), calendar.getTime());

        calendar.setWeekDate(2022, weekNo, Calendar.FRIDAY);
        calendar = calendar;
        setCanvasColor(canvas5);
        weekDates.put(canvas5.getId(), calendar.getTime());

        calendar.setWeekDate(2022, weekNo, Calendar.SATURDAY);
        calendar = calendar;
        setCanvasColor(canvas6);
        weekDates.put(canvas6.getId(), calendar.getTime());

        calendar.setWeekDate(2022, weekNo, Calendar.SUNDAY);
        calendar = calendar;
        setCanvasColor(canvas7);
        weekDates.put(canvas7.getId(), calendar.getTime());

        lblMonth.setText(userSettings.getLocaleMonth());
    }

    public void btnLeftClick(ActionEvent actionEvent) {
        weekNo--;
        loadGanttDiagram();
    }

    public void btnRightClick(ActionEvent actionEvent) {
        weekNo++;
        loadGanttDiagram();
    }

    public void setCanvasColor(Canvas cnv){
        canvasDateMap.put(cnv, getDateString());
        System.out.println(canvasDateMap);
        cnv.getGraphicsContext2D().setFill(Color.ORANGE);
        cnv.getGraphicsContext2D().setTextAlign(TextAlignment.CENTER);
        cnv.getGraphicsContext2D().setFont(Font.font("Comic Sans MS", 18));
        cnv.getGraphicsContext2D().setTextBaseline(VPos.CENTER);
        cnv.getGraphicsContext2D().fillText(
                getDateString(),
                Math.round(cnv.getWidth()  / 2),
                Math.round(cnv.getHeight() / 2)
        );
    }

    public void clearDiagramOnAction(ActionEvent actionEvent) {
        tfToTime.setText("");
        tfFromTime.setText("");
        dpDate.setValue(null);
        clearDiagram();
        loadGanttDiagram();
        isEditStart = false;
    }

    public void clearDiagram(){
        canvas1.getGraphicsContext2D().setFill(Color.PAPAYAWHIP);
        canvas1.getGraphicsContext2D().fillRect(0, 0, canvas1.getWidth(), canvas1.getHeight());
        canvas2.getGraphicsContext2D().setFill(Color.LIGHTGOLDENRODYELLOW);
        canvas2.getGraphicsContext2D().fillRect(0, 0, canvas2.getWidth(), canvas2.getHeight());
        canvas3.getGraphicsContext2D().setFill(Color.PAPAYAWHIP);
        canvas3.getGraphicsContext2D().fillRect(0, 0, canvas3.getWidth(), canvas3.getHeight());
        canvas4.getGraphicsContext2D().setFill(Color.LIGHTGOLDENRODYELLOW);
        canvas4.getGraphicsContext2D().fillRect(0, 0, canvas4.getWidth(), canvas4.getHeight());
        canvas5.getGraphicsContext2D().setFill(Color.PAPAYAWHIP);
        canvas5.getGraphicsContext2D().fillRect(0, 0, canvas5.getWidth(), canvas5.getHeight());
        canvas6.getGraphicsContext2D().setFill(Color.LIGHTGOLDENRODYELLOW);
        canvas6.getGraphicsContext2D().fillRect(0, 0, canvas6.getWidth(), canvas6.getHeight());
        canvas7.getGraphicsContext2D().setFill(Color.PAPAYAWHIP);
        canvas7.getGraphicsContext2D().fillRect(0, 0, canvas7.getWidth(), canvas7.getHeight());
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        saveAsPng(windowSt, tfProjectNameSt.getText(), ssp);// выбор формата и отдельные методы, вынести в класс
    }

    public void chooseSaveDir(){
        alertSaveDir = new Alert(Alert.AlertType.INFORMATION);
        stage = new Stage();
        directoryChooser = new DirectoryChooser();

        alertSaveDir.setTitle("Путь для сохранения файлов");
        alertSaveDir.setHeaderText("Внимание!");

        directoryChooser.setTitle("Выберите каталог для сохранения");
        selectedDirectory = directoryChooser.showDialog(stage);

        if (selectedDirectory != null) {
          saveDir = selectedDirectory.getAbsolutePath();
        }

        alertSaveDir.setContentText("Для сохранения выбран путь " + saveDir + "\nЕсли хотите изменить путь, перезапустите программу.");
        alertSaveDir.showAndWait();
    }
    public void setToolTips(){
        btnSave.setTooltip(new Tooltip("Сохранить диаграмму"));
        btnClear.setTooltip(new Tooltip("Очистить диаграмму Ганта"));
        btnRight.setTooltip(new Tooltip("Перевод календаря на неделю вперед"));
        btnLeft.setTooltip(new Tooltip("Перевод календаря на неделю назад"));
        toNext.setTooltip(new Tooltip("Переход на страницу Методиста"));
        btnAddToPlanSt.setTooltip(new Tooltip("Добавить событие в план (таблица ниже)"));
        btnCloseSt.setTooltip(new Tooltip("Закрыть окно программы"));
        lblColorBlock.setTooltip(new Tooltip("Выберите цвет контура блока и текста комментария"));
        tfProjectNameSt.setTooltip(new Tooltip("Это название будет выбрано для сохранения файла"));
    }
    public void saveAsPng(Node node, String fname, SnapshotParameters ssp) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(saveDir + "\\" + fname + ".dat")))
        {
            oos.writeObject(node);
        }
        catch(Exception ex){
            alertSaveDir = new Alert(Alert.AlertType.ERROR);
            alertSaveDir.setTitle("Сохранение файла");
            alertSaveDir.setHeaderText("Внимание!");
            alertSaveDir.setContentText(ex.getMessage());
            alertSaveDir.showAndWait();
        }
    }

    public void chooseColorOnAction(ActionEvent actionEvent) {
        if(isEditStart){
            if(decRectan==null){
                decRectan=new Conturee(userSettings.getShape(), Color.DARKORANGE);
            }
            else{
                decRectan=new Conturee(userSettings.getShape(), cpBlockColor.getValue());
            }

            decRectan.draw(userSettings.getContext());
        }
    }

    public void taCommentInputChange(MouseEvent inputMethodEvent) {
        if(isEditStart && decRectan!=null){
            decRectan=new Conturee(userSettings.getShape(), cpBlockColor.getValue());
            decRectan.draw(userSettings.getContext());
            decRectan=new Textt(userSettings.getShape(), taComment.getText(), Color.WHITE);
            decRectan.draw(userSettings.getContext());
        }
    }
}
