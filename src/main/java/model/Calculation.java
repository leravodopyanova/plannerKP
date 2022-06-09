package model;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;

/**
 * Класс, выполняющий вычисления времени для фигуры.
 * <p>
 *     Выполняет вычисления времени по координате Х левой и/или правой границы фигуры.
 * </p>
 * @author Водопьянова Валерия
 * @version 1.1
 */

public class Calculation {
    private final double LENGTH = 642.0;
    private final double MINUTE_IN_PX = 1440.0/642; // минуты в 24 часах на длину шкалы в пикселях = 1px = минут
    private final double HOUR_IN_PX = 24/642.0;
    private int hours;
    private float minutes;
    private double hours_length_in_px;
    private double minutes_length_in_px;
    private String time;

    /**
     * Этот метод возвращает продолжительность отрезка времени между параметрами (координат) x1 и x2.
     * <p>
     *     Не имеет значения, какой из параметров имеет большее значение.
     * </p>
     * @param x1 Значение координаты Х одной из боковых границ прямоугольника.
     * @param x2 Значение координаты Х второй из боковых границ прямоугольника.
     * @return Целочисленное значение (<b>в минутах</b>) продолжительности отрезка времени между параметрами координат x1 и x2.
     */
    public int getTimeSubj_min(double x1, double x2){
        return Integer.parseInt(String.valueOf(Math.round(Math.abs(x1-x2) * MINUTE_IN_PX)));
    }

    /**
     *  Этот метод возвращает продолжительность отрезка времени между параметрами (координат) x1 и x2 в формате ЧЧ:ММ.
     * @param x1 Значение координаты Х одной из боковых границ прямоугольника.
     * @param x2 Значение координаты Х второй из боковых границ прямоугольника.
     * @return Строквое значение продолжительности отрезка времени между параметрами координат x1 и x2 в формате ЧЧ:ММ.
     */
    public String getStringFullTimeSubj(double x1, double x2){
        hours = getTimeSubj_min(x1, x2)/60;
        minutes = getTimeSubj_min(x1, x2)%60;

        if(minutes < 10) {
            return String.valueOf(hours) + ":0" + String.valueOf( Integer.valueOf((int) minutes));
        }
        else{
            return String.valueOf(hours) + ":" + String.valueOf( Integer.valueOf((int) minutes));
        }
    }

    /**
     *  Этот метод возвращает время в точке с координатой x.
     * @param x Значение координаты Х боковой границы прямоугольника.
     * @return Целочисленное значение времени (<b>в минутах</b>) в точке с координатой x.
     */
    public int getTimePointInMinutes(double x){
        return Integer.parseInt(String.valueOf(Math.round(Math.abs(x) * MINUTE_IN_PX)));
    }

    /**
     *  Этот метод возвращает время в формате ЧЧ:ММ в точке с координатой x.
     * @param x Значение координаты Х боковой границы прямоугольника.
     * @return Строковое значение времени в формате ЧЧ:ММ в точке с координатой x.
     */
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

    /**
     *  Этот метод устанавливает время левой и правой границы фигуры в формате ЧЧ:ММ
     *  в поля TextField начала выполнения задачи <b>from</b> и ее окончания <b>to</b>.
     *  <p>
     *      Не имеет значения, какое из полученных значений времени (time1 или time2) меньше.
     *  </p>
     *  <p>
     *      Определяет, какое время больше.
     *  </p>
     * @param time1 Значение времени одной из боковых границ фигуры.
     * @param time2 Значение времени второй боковой границы фигуры.
     * @param from Текстовое поле для отображения времени начала задачи.
     * @param to Текстовое поле для отображения времени окончания задачи.
     * @see TextField
     */
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

    /**
     * Этот метод отображает в datePicker значение даты из списка дат отображаемой недели weekDates по Id заданной canvas.
     * <p>
     *     Старая дата в поле datePicker обнуляется при каждом вызове метода.
     * </p>
     * @param canvas Графический объект отображения задачи, из которого требуется получить соответствующую дату.
     * @param weekDates Набор, хранящий соответствие даты и canvas, к которой она пренадлежит.
     * @param datePicker Поле для отображения полученной даты.
     * @see DatePicker
     * @see Canvas
     * @see HashMap
     */
    public void setDateField(Canvas canvas, HashMap<String, Date> weekDates, DatePicker datePicker){
        datePicker.setValue(null);
        Date weekDay = weekDates.get(canvas.getId());
        datePicker.setValue(weekDay.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
    }
}
