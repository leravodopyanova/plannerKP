package model;

import javafx.scene.paint.Color;

import java.io.Serializable;
import java.time.LocalDate;
/**
 * Класс, реализующий структуру табличной модели данных диаграммы.
 * @author Водопьянова Валерия
 * @version 1.1
 */

public class tableViewPlan implements Serializable {
    private int colNo;
    private LocalDate colDate;
    private String colDiscipl;
    private String colFrom;
    private String colTo;
    private String colStatus;
    private String colComm;
    private Color colColor;
    private int colWeekNo;

    /**
     * Конструктор класса без параметров.
     */
    public tableViewPlan() {
    }

    /**
     * Конструктор класса с параметрами модели данных.
     * @param colNo Параметр номера столбца.
     * @param colDate Параметр даты выполнения задачи.
     * @param colDiscipl Параметр названия дисциплины.
     * @param colFrom Параметр времени начала выполнения задачи.
     * @param colTo Параметр времени окончания выполнения задачи.
     * @param colStatus Параметр статуса выполнения задачи.
     * @param colComm Параметр текста комментария для задачи.
     * @param colColor Параметр цвета заливки графического отображения задачи.
     * @param colWeekNo Параметр номера недели по дате выполнения задачи.
     */
    public tableViewPlan(int colNo, LocalDate colDate, String colDiscipl, String colFrom, String colTo, String colStatus, String colComm, Color colColor, int colWeekNo) {
        this.colNo = colNo;
        this.colDate = colDate;
        this.colDiscipl = colDiscipl;
        this.colFrom = colFrom;
        this.colTo = colTo;
        this.colStatus = colStatus;
        this.colComm = colComm;
        this.colColor = colColor;
        this.colWeekNo = colWeekNo;
    }

    /**
     * Этот метод получает номер строки таблицы = номеру задачи.
     * @return Значение номера строки таблицы.
     */
    public int getColNo() {
        return colNo;
    }

    /**
     * Этот метод задает значение номера задачи.
     * @param colNo Значение номера задачи.
     */
    public void setColNo(int colNo) {
        this.colNo = colNo;
    }

    /**
     * Этот метод получает дату выполнения задачи.
     * @return Значение даты выполнения задачи.
     */
    public LocalDate getColDate() {
        return colDate;
    }

    /**
     * Этот метод задает значение даты выполнения задачи.
     * @param colDate Значение даты выполнения задачи.
     */
    public void setColDate(LocalDate colDate) {
        this.colDate = colDate;
    }

    /**
     * Этот метод получает название дисциплины (задачи).
     * @return Значение названия дисциплины.
     */
    public String getColDiscipl() {
        return colDiscipl;
    }

    /**
     * Этот метод задает значение названия дисциплины.
     * @param colDiscipl Значение названия дисциплины.
     */
    public void setColDiscipl(String colDiscipl) {
        this.colDiscipl = colDiscipl;
    }

    /**
     * Этот метод получает время начала выполнения задачи.
     * @return Значение времени начала выполнения задачи.
     */
    public String getColFrom() {
        return colFrom;
    }

    /**
     * Этот метод задает значение времени начала выполнения задачи.
     * @param colFrom Значение времени начала выполнения задачи.
     */
    public void setColFrom(String colFrom) {
        this.colFrom = colFrom;
    }

    /**
     * Этот метод получает время окончания выполнения задачи.
     * @return Значение времени окончания выполнения задачи.
     */
    public String getColTo() {
        return colTo;
    }

    /**
     * Этот метод задает значение времени окончания выполнения задачи.
     * @param colTo Значение времени окончания выполнения задачи.
     */
    public void setColTo(String colTo) {
        this.colTo = colTo;
    }

    /**
     * Этот метод получает статус выполнения задачи.
     * @return Значение статуса выполнения задачи.
     */
    public String getColStatus() {
        return colStatus;
    }

    /**
     * Этот метод задает значение статуса выполнения задачи.
     * @param colStatus Значение статуса выполнения задачи.
     */
    public void setColStatus(String colStatus) {
        this.colStatus = colStatus;
    }

    /**
     * Этот метод получает текст комментария к задаче.
     * @return Значение текста комментария к задаче.
     */
    public String getColComm() {
        return colComm;
    }

    /**
     * Этот метод задает значение текста комментария к задаче.
     * @param colComm Значение текста комментария к задаче.
     */
    public void setColComm(String colComm) {
        this.colComm = colComm;
    }

    /**
     * Этот метод получает цвет графического отображения задачи.
     * @return Значение цвета графического отображения задачи.
     */
    public Color getColColor() {
        return colColor;
    }

    /**
     * Этот метод задает значение цвета графического отображения задачи.
     * @param colColor Значение цвета графического отображения задачи.
     */
    public void setColColor(Color colColor) {
        this.colColor = colColor;
    }

    /**
     * Этот метод получает номер недели выполнения задачи.
     * @return Значение номера недели выполнения задачи.
     */
    public int getColWeekNo() {
        return colWeekNo;
    }

    /**
     * Этот метод задает значение номера недели выполнения задачи.
     * @param colWeekNo Значение номера недели выполнения задачи.
     */
    public void setColWeekNo(int colWeekNo) {
        this.colWeekNo = colWeekNo;
    }
}
