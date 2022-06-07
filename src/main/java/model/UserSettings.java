package model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class UserSettings extends DrawStudies{
    private Calendar calendar;
    private GraphicsContext gr;
    private Rectan rect;


    public UserSettings(){
        this.calendar = Calendar.getInstance();
    }

    public String getLocaleMonth(){
        if (calendar.get(Calendar.MONTH) == Calendar.JANUARY){
            return "Январь";
        }
        else if(calendar.get(Calendar.MONTH) == Calendar.FEBRUARY){
            return "Февраль";
        }
        else if(calendar.get(Calendar.MONTH) == Calendar.MARCH){
            return "Март";
        }
        else if(calendar.get(Calendar.MONTH) == Calendar.APRIL){
            return "Апрель";
        }
        else if(calendar.get(Calendar.MONTH) == Calendar.MAY){
            return "Май";
        }
        else if(calendar.get(Calendar.MONTH) == Calendar.JUNE){
            return "Июнь";
        }
        else if(calendar.get(Calendar.MONTH) == Calendar.JULY){
            return "Июль";
        }
        else if(calendar.get(Calendar.MONTH) == Calendar.AUGUST){
            return "Август";
        }
        else if(calendar.get(Calendar.MONTH) == Calendar.SEPTEMBER){
            return "Сентябрь";
        }
        else if(calendar.get(Calendar.MONTH) == Calendar.OCTOBER){
            return "Октябрь";
        }
        else if(calendar.get(Calendar.MONTH) == Calendar.NOVEMBER){
            return "Ноябрь";
        }
        else {
            return "Декабрь";
        }
    }

    public void CanvasClick(TextField from, TextField to, Canvas canvas, MouseEvent mouseEvent, Rectan rectan, HashMap<String, Date> weekDates, DatePicker datePicker){
        from.setText("");
        to.setText("");
        gr = canvas.getGraphicsContext2D();
        rect = rectan;
        rect.setX(mouseEvent.getX());
        rect.setY(mouseEvent.getY());
        drawActivity(gr, mouseEvent, rect, from, to);
        System.out.println(weekDates);
        setDateField(canvas, weekDates, datePicker);
    }

    public ShapeDraw getShape(){
        return getRectan();
    }
    public GraphicsContext getContext(){
        return getGraphicContent();
    }
}
