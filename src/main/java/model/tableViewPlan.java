package model;

import javafx.scene.paint.Color;

import java.io.Serializable;
import java.time.LocalDate;

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

    public tableViewPlan() {
    }

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

    public int getColNo() {
        return colNo;
    }

    public void setColNo(int colNo) {
        this.colNo = colNo;
    }

    public LocalDate getColDate() {
        return colDate;
    }

    public void setColDate(LocalDate colDate) {
        this.colDate = colDate;
    }

    public String getColDiscipl() {
        return colDiscipl;
    }

    public void setColDiscipl(String colDiscipl) {
        this.colDiscipl = colDiscipl;
    }

    public String getColFrom() {
        return colFrom;
    }

    public void setColFrom(String colFrom) {
        this.colFrom = colFrom;
    }

    public String getColTo() {
        return colTo;
    }

    public void setColTo(String colTo) {
        this.colTo = colTo;
    }

    public String getColStatus() {
        return colStatus;
    }

    public void setColStatus(String colStatus) {
        this.colStatus = colStatus;
    }

    public String getColComm() {
        return colComm;
    }

    public void setColComm(String colComm) {
        this.colComm = colComm;
    }

    public Color getColColor() {
        return colColor;
    }

    public void setColColor(Color colColor) {
        this.colColor = colColor;
    }

    public int getColWeekNo() {
        return colWeekNo;
    }

    public void setColWeekNo(int colWeekNo) {
        this.colWeekNo = colWeekNo;
    }
}
