package model;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;

public class Calculation {
    private final double LENGTH = 642.0;
    private final double MINUTE_IN_PX = 1440.0/642; // минуты в 24 часах на длину шкалы в пикселях = 1px = минут
    private final double HOUR_IN_PX = 24/642.0;
    private int hours;
    private float minutes;
    private double hours_length_in_px;
    private double minutes_length_in_px;
    private String time;


    //сколько в отрезке времени (мин)
    public int getTimeSubj_min(double x1, double x2){
        return Integer.parseInt(String.valueOf(Math.round(Math.abs(x1-x2) * MINUTE_IN_PX)));
    }
    //сколько в отрезке времени (чч:мм)
    public String getTimeSubjAllTime(double x1, double x2){
        hours = getTimeSubj_min(x1, x2)/60;
        minutes = getTimeSubj_min(x1, x2)%60;
        if(minutes < 10) {
            return String.valueOf(hours) + ":0" + String.valueOf( Integer.valueOf((int) minutes));
        }
        else{
            return String.valueOf(hours) + ":" + String.valueOf( Integer.valueOf((int) minutes));
        }
    }

    // сколько в точке времени (мин)
    public int getTimePointInMinutes(double x){
        return Integer.parseInt(String.valueOf(Math.round(Math.abs(x) * MINUTE_IN_PX)));
    }
    // сколько в точке времени (чч:мм)
    public String getTimePoint(double x){
        hours = getTimePointInMinutes(x)/60;
        minutes = getTimePointInMinutes(x)%60;
        if(minutes < 10) {
            return String.valueOf(hours) + ":0" + String.valueOf( Integer.valueOf((int) minutes));
        }
        else{
            return String.valueOf(hours) + ":" + String.valueOf( Integer.valueOf((int) minutes));
        }
    }
    public void setTextFieldsByTime(String time1, String time2, TextField from, TextField to){
        String hh1 = time1.substring(0, time1.indexOf(":"));
        String mm1 = time1.substring(time1.indexOf(":") + 1);
        String hh2 = time2.substring(0, time2.indexOf(":"));
        String mm2 = time2.substring(time2.indexOf(":") + 1);

        if(Integer.parseInt(hh1) < Integer.parseInt(hh2)){
            from.setText(time1);
            to.setText(time2);
        } else if (Integer.parseInt(hh1) == Integer.parseInt(hh2)) {
            if(Integer.parseInt(mm1) <= Integer.parseInt(mm2)){
                from.setText(time1);
                to.setText(time2);
            }
            else{
                from.setText(time2);
                to.setText(time1);
            }
        } else{
            from.setText(time2);
            to.setText(time1);
        }
    }
    public void setDateField(Canvas canvas, HashMap<String, Date> weekDates, DatePicker datePicker){
        datePicker.setValue(null);
        Date weekDay = weekDates.get(canvas.getId());
        datePicker.setValue(weekDay.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
    }
}
