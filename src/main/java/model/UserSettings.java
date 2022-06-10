package model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
/**
 * Класс, реализующий настройку интерфейса пользователя и логику взаимодействия с интерфейсом.
 * @author Водопьянова Валерия
 * @version 1.1
 */
public class UserSettings extends DrawStudies{
    private Calendar calendar;
    private GraphicsContext gr;
    private Rectan rect;

    /**
     * Конструктор класса без параметров.
     */
    public UserSettings(){
        this.calendar = Calendar.getInstance();
    }

    /**
     * Этот метод реализует локализацию названий месяца на русский язык.
     * @return Значение названия месяца на русском языке.
     */
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
            String str ="June";
            return str;
        }
        else if(calendar.get(Calendar.MONTH) == Calendar.JULY){
            return "July";
        }
        else if(calendar.get(Calendar.MONTH) == Calendar.AUGUST) return "Август";
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

    /**
     * Этот метод реализует логику взаимодействия пользователя с холстом <b>canvas</b>.
     * <p>
     *     Рисует задачи на диаграмме Ганта по клику пользователя по холсту.
     * </p>
     * <p>
     *     Заполняет поля начала и окончания выполнения задач в поля TextField.
     * </p>
     * <p>
     *     Заполняет поле DatePicker датой выполнения задачи, заданной на конкретном холсте canvas.
     * </p>
     * @param from Параметр текстового поля для задания времени начала выполнения задачи.
     * @param to Параметр текстового поля для задания времени окончания выполнения задачи.
     * @param canvas Параметр холста для рисования фигур.
     * @param mouseEvent Параметр полученный по событию мыши.
     * @param rectan Параметр фигуры для рисования.
     * @param weekDates Параметр набора дат недели, отображаемых на экране пользователя.
     * @param datePicker Параметр поля даты для вывода дня по клику на холст.
     * @see Canvas
     * @see TextField
     */
    public void CanvasClick(TextField from, TextField to, Canvas canvas, MouseEvent mouseEvent, Rectan rectan, HashMap<String, Date> weekDates, DatePicker datePicker){
        from.setText("");
        to.setText("");
        gr = canvas.getGraphicsContext2D();
        rect = rectan;
        rect.setX(mouseEvent.getX());
        rect.setY(mouseEvent.getY());
        drawActivity(gr, mouseEvent, rect, from, to);
        setDateField(canvas, weekDates, datePicker);
    }

    /**
     * Этот метод получает объект фигуры для прорисовки.
     * @return Значение объекта фигуры для прорисовки.
     */
    public ShapeDraw getShape(){
        return getRectan();
    }

    /**
     * Этот метод возвращает последнее сохраненное значение объекта гоафического буфера.
     * @return Объект графического буфера.
     */
    public GraphicsContext getContext(){
        return getGraphicContent();
    }
}
