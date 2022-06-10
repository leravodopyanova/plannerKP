package com.example.planner1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.*;

/**
 * Класс (контроллер), реализующий взаимодействие пользователя с моделью данных.
 * <p>
 *     Позволяет изменить состояние объектов модели данных за счет обработки событий пользователя.
 * </p>
 * @author Водопьянова Валерия
 * @version 1.1
 */

public class Controller implements Initializable {
    public TextField tfDisciplineSt;
    public CheckBox chbIsDone;
    public Canvas canvas1;
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
    public Button btnRight;
    public Button btnLeft;
    public Button toNext;
    public Label lblColorBlock;
    public GridPane gridPaneNode = new GridPane();
    private final ObservableList<String> extensions = FXCollections.observableArrayList( ".png", ".dat");
    public ComboBox cmbTypeFile;
    public Button btnClose11;
    public Button btnClose111;
    public Button btnHow;
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
    public DatePicker dpDate;
    public Button btnCloseSt;
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
    @FXML
    private TextField tfProjectNameSt;
    @FXML
    private TextField tfProjectNameM;
    public GraphicsContext gr;
    private SnapshotParameters ssp;
    public UserSettings userSettings;
    private Calendar calendar = Calendar.getInstance();
    private LocalDate date;
    private Locale locale = Locale.ENGLISH;
    private GregorianCalendar gnow;
    private int countCol = 0;
    private int weekNo;
    private CheckClass checkClass;
    private Rectan rectan;
    private Decorator decRectan;
    private HashMap<Canvas, String> canvasDateMap = new HashMap<>();
    private  HashMap<String, Date> weekDates = new HashMap<>();
    private boolean isEditStart = false;
    private SaveSettings saveSettings = new SavePng("", "1", ".png");
    private String selectedExtension = "";
    private String selectedDir = "";
    private SaveFactory saveFactory;

    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gnow = new GregorianCalendar();
        checkClass = new CheckClass();
        userSettings = new UserSettings();
        saveFactory = new SaveFactory();
        decRectan = null;
        saveSettings.chooseSaveDir();
        selectedDir = saveSettings.getSaveDir();
        setToolTips();

        cmbTypeFile.setItems(extensions);
        weekNo = LocalDateTime.now().get(WeekFields.of(locale).weekOfWeekBasedYear()) - 1;
        lblMonth.setText(userSettings.getLocaleMonth());
        lblWeekNom.setText("Неделя " + weekNo);
        ssp = new SnapshotParameters();

        // Для отображения стиля названия проекта
        tfProjectNameSt.setStyle("-fx-text-fill: #AFEEEE; -fx-background-color: rgba(0,0,0,0);");
        //tfProjectNameM.setStyle("-fx-text-fill: #AFEEEE; -fx-background-color: rgba(0,0,0,0);");

        // Закрытие по кнопке
        btnCloseSt.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.exit(0);
            }
        });

        toNext.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // переход к следующему окну
                starMethodistWindow();
            }
        });

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

    /**
     * Этот метод открывает окно для роли Методиста.
     */
    private void starMethodistWindow() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("WorkPlacemathodist.fxml"));
            Stage stage = new Stage();
            stage.setMaximized(true);
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Этот метод открывает окно для роли Методиста.
     */
    private void starStudentWindow() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("WorkPlaceStudent.fxml"));
            Stage stage = new Stage();
            stage.setMaximized(true);
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Этот обработчик событий реализует добавления данных задачи в таблицу.
     * @param actionEvent Параметр события.
     */
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

    /**
     * Этот метод реализует инициализацию модели табличных данных.
     */
    private void init_Data() {
        date = dpDate.getValue();
        weekNo = date.get(WeekFields.of(locale).weekOfWeekBasedYear());
        countCol++;
        tableViewPlans.add(new tableViewPlan(countCol, dpDate.getValue(),
                tfDisciplineSt.getText(), tfFromTime.getText(), tfToTime.getText(),
                checkClass.checkStatus(chbIsDone.isSelected()),
                taComment.getText(), cpBlockColor.getValue(), weekNo));
    }

    /**
     * Обработчик события клика мыши по холсту canvas1.
     * <p>
     *     Рисует задачи на диаграмме Ганта. Определяте, дату, время начала и окончания выполнения задачи.
     * </p>
     * @param mouseEvent Параметр события клика мыши.
     * @see Canvas
     */
    public void onCanva1_clicked(MouseEvent mouseEvent) {
        userSettings.CanvasClick(tfFromTime, tfToTime, canvas1, mouseEvent, rectan, weekDates, dpDate);
        isEditStart = true;
    }

    /**
     * Обработчик события клика мыши по холсту canvas2.
     * <p>
     *     Рисует задачи на диаграмме Ганта. Определяте, дату, время начала и окончания выполнения задачи.
     * </p>
     * @param mouseEvent Параметр события клика мыши.
     * @see Canvas
     */
    public void onCanva2_clicked(MouseEvent mouseEvent) {
        userSettings.CanvasClick(tfFromTime, tfToTime, canvas2, mouseEvent, rectan, weekDates, dpDate);
        isEditStart = true;
    }

    /**
     * Обработчик события клика мыши по холсту canvas3.
     * <p>
     *     Рисует задачи на диаграмме Ганта. Определяте, дату, время начала и окончания выполнения задачи.
     * </p>
     * @param mouseEvent Параметр события клика мыши.
     * @see Canvas
     */
    public void onCanva3_clicked(MouseEvent mouseEvent) {
        userSettings.CanvasClick(tfFromTime, tfToTime, canvas3, mouseEvent, rectan, weekDates, dpDate);
        isEditStart = true;
    }

    /**
     * Обработчик события клика мыши по холсту canvas4.
     * <p>
     *     Рисует задачи на диаграмме Ганта. Определяте, дату, время начала и окончания выполнения задачи.
     * </p>
     * @param mouseEvent Параметр события клика мыши.
     * @see Canvas
     */
    public void onCanva4_clicked(MouseEvent mouseEvent) {
        userSettings.CanvasClick(tfFromTime, tfToTime, canvas4, mouseEvent, rectan, weekDates, dpDate);
        isEditStart = true;
    }

    /**
     * Обработчик события клика мыши по холсту canvas5.
     * <p>
     *     Рисует задачи на диаграмме Ганта. Определяте, дату, время начала и окончания выполнения задачи.
     * </p>
     * @param mouseEvent Параметр события клика мыши.
     * @see Canvas
     */
    public void onCanva5_clicked(MouseEvent mouseEvent) {
        userSettings.CanvasClick(tfFromTime, tfToTime, canvas5, mouseEvent, rectan, weekDates, dpDate);
        isEditStart = true;
    }

    /**
     * Обработчик события клика мыши по холсту canvas6.
     * <p>
     *     Рисует задачи на диаграмме Ганта. Определяте, дату, время начала и окончания выполнения задачи.
     * </p>
     * @param mouseEvent Параметр события клика мыши.
     * @see Canvas
     */
    public void onCanva6_clicked(MouseEvent mouseEvent) {
        userSettings.CanvasClick(tfFromTime, tfToTime, canvas6, mouseEvent, rectan, weekDates, dpDate);
        isEditStart = true;
    }

    /**
     * Обработчик события клика мыши по холсту canvas7.
     * <p>
     *     Рисует задачи на диаграмме Ганта. Определяте, дату, время начала и окончания выполнения задачи.
     * </p>
     * @param mouseEvent Параметр события клика мыши.
     * @see Canvas
     */
    public void onCanva7_clicked(MouseEvent mouseEvent) {
        userSettings.CanvasClick(tfFromTime, tfToTime, canvas7, mouseEvent, rectan, weekDates, dpDate);
        isEditStart = true;
    }

    /**
     * Этот метод получает строку даты из Calendar.
     * @return Строка даты ДД.ММ.ГГ.
     * @see Calendar
     */
    public String getDateString(){
        String dateStr = calendar.getTime().toString();
        dateStr = dateStr.substring(4, 11) + dateStr.substring((dateStr.length() - 4));
        return dateStr;
    }

    /**
     * Этот метод выполняет загрузку диаграммы Ганта в окно программы. <br>
     * Устанавливает номер недели, месяц и цвет полей диаграммы. <br>
     * Заполняет набор HashMap для сохранения дат отображаемой недели. <br>
     * Каждое выполнения метода начинается с очистки набора соответствий Id холста и дат canvasDateMap, а также набора соответствий Id холста и дат canvasDateMap.
     * @see HashMap
     */
    public void loadGanttDiagram(){
        canvasDateMap.clear();
        weekDates.clear();
        clearDiagram();

        lblWeekNom.setText("Неделя " + weekNo);

        calendar.setWeekDate(2022, weekNo, Calendar.MONDAY);
        setCanvasColor(canvas1);
        weekDates.put(canvas1.getId(), calendar.getTime());

        calendar.setWeekDate(2022, weekNo, Calendar.TUESDAY);
        setCanvasColor(canvas2);
        weekDates.put(canvas2.getId(), calendar.getTime());

        calendar.setWeekDate(2022, weekNo, Calendar.WEDNESDAY);
        setCanvasColor(canvas3);
        weekDates.put(canvas3.getId(), calendar.getTime());

        calendar.setWeekDate(2022, weekNo, Calendar.THURSDAY);
        setCanvasColor(canvas4);
        weekDates.put(canvas4.getId(), calendar.getTime());

        calendar.setWeekDate(2022, weekNo, Calendar.FRIDAY);
        setCanvasColor(canvas5);
        weekDates.put(canvas5.getId(), calendar.getTime());

        calendar.setWeekDate(2022, weekNo, Calendar.SATURDAY);
        setCanvasColor(canvas6);
        weekDates.put(canvas6.getId(), calendar.getTime());

        calendar.setWeekDate(2022, weekNo, Calendar.SUNDAY);
        setCanvasColor(canvas7);
        weekDates.put(canvas7.getId(), calendar.getTime());

        lblMonth.setText(userSettings.getLocaleMonth());
    }

    /**
     * Этот обработчик событий перелистывает даты на неделю назад.
     * @param actionEvent Параметр обработчика событий клика по кнопке.
     */
    public void btnLeftClick(ActionEvent actionEvent) {
        weekNo--;
        loadGanttDiagram();
    }

    /**
     * Этот обработчик событий перелистывает даты на неделю вперед.
     * @param actionEvent Параметр обработчика событий клика по кнопке.
     */
    public void btnRightClick(ActionEvent actionEvent) {
        weekNo++;
        loadGanttDiagram();
    }

    /**
     * Этот метод устанавливает цветовое оформление холстов.
     * Формирует карту соответствий холста и дат на холсте.
     * @param cnv Параметр холста для цветового оформления.
     */
    public void setCanvasColor(Canvas cnv){
        canvasDateMap.put(cnv, getDateString());
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

    /**
     * Этот обработчик событий очищает диаграмму Ганта от задач.
     * Очищает дату и время выполнения задач.
     * @param actionEvent Параметр обработчика событий клика по кнопке.
     */
    public void clearDiagramOnAction(ActionEvent actionEvent) {
        tfToTime.setText("");
        tfFromTime.setText("");
        dpDate.setValue(null);
        clearDiagram();
        loadGanttDiagram();
        isEditStart = false;
    }

    /**
     * Этот метод очищает диаграмму Ганта от задач.
     */
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

    /**
     * Этот обработчик событий реализует сохранение данных программы в файл.
     * @param actionEvent Параметр обработчика событий клика по кнопке.
     * @throws IOException
     * @see IOException
     */
    public void btnSaveOnAction(ActionEvent actionEvent) throws IOException {
        selectedExtension = cmbTypeFile.getValue().toString();
        saveSettings = saveFactory.ChooseSaveMethod(selectedDir, tfProjectNameSt.getText(), selectedExtension, tableViewPlans);
        saveSettings.saveToFile(gridPaneNode, ssp);
    }

    /**
     * Этот метод устанавливает всплывающие подсказки.
     */
    public void setToolTips(){
        btnSave.setTooltip(new Tooltip("Сохранить диаграмму (png), или таблицу (xlsx, dat)"));
        btnClear.setTooltip(new Tooltip("Очистить диаграмму Ганта"));
        btnRight.setTooltip(new Tooltip("Перевод календаря на неделю вперед"));
        btnLeft.setTooltip(new Tooltip("Перевод календаря на неделю назад"));
        toNext.setTooltip(new Tooltip("Переход на страницу Методиста"));
        btnAddToPlanSt.setTooltip(new Tooltip("Добавить событие в план (таблица ниже)"));
        btnCloseSt.setTooltip(new Tooltip("Закрыть окно программы"));
        lblColorBlock.setTooltip(new Tooltip("Выберите цвет контура блока и текста комментария"));
        tfProjectNameSt.setTooltip(new Tooltip("Это название будет выбрано для сохранения файла"));
        btnHow.setTooltip(new Tooltip("Кликните по строке с нужным днем и под нужным временем - первая граница задачи, второй клик - для обозначения второй границы.\n" +
                "Третий клик по пустому месту строки - заливка задачи цветом по умолчанию."));

    }

    /**
     * Этот обработчик событий реализует выбор цвета по клику на поле выбора цвета.
     * @param actionEvent Параметр обработчика событий клика по кнопке.
     */
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

    /**
     * Этот обработчик событий реализует применения декора задачи (заливки и добавления текста на задачу).
     * @param inputMethodEvent Параметр обработчика события движения мыши.
     */
    public void taCommentInputChange(MouseEvent inputMethodEvent) {
        if(isEditStart && decRectan!=null){
            decRectan=new Conturee(userSettings.getShape(), cpBlockColor.getValue());
            decRectan.draw(userSettings.getContext());
            decRectan=new Textt(userSettings.getShape(), taComment.getText(), Color.WHITE);
            decRectan.draw(userSettings.getContext());
        }
    }
}
