package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
/**
 * Класс, задающий логику для рисования задач на диаграмме.
 * <p>
 *     Наследует реализацию класса Calculation.
 * </p>
 * @author Водопьянова Валерия
 * @version 1.1
 * @see Calculation
 */

public class DrawStudies extends Calculation{
    private final double Y1 = 0;
    private final double Y2 = 0;
    private double x1;
    private double x2;
    private int key = 0;
    private Rectan rectan;
    private GraphicsContext gr;

    /**
     * Этот метод реализует логику построения фигуры для отображения задачи.
     * <p>
     *     Определяет границы задачи, между которыми будет зарисована фигура для отображения задачи.
     * </p>
     * <p>
     *     Выводит в текстовые поля время начала и окончания задач.
     * </p>
     * @param gr Объект, задающий графический буфер для вывода графических объектов.
     * @param mouseEvent Значение, получаемое по событию мыши.
     * @param rectan Объект фигуры для зарисовки задачи.
     * @param from Текстовое поле для вывода начала задачи.
     * @param to Текстовое поле для вывода окончания задачи.
     */
    public void drawActivity(GraphicsContext gr, MouseEvent mouseEvent, Rectan rectan, TextField from, TextField to){
        this.gr = gr;
        if(key == 0){
            from.setText("");
            to.setText("");
            x1 = mouseEvent.getX();
            rectan = new Rectan(Color.DARKORANGE, 40, 1, x1, 0);
            rectan.draw(gr);
            key++;
        }

        if(key == 2){
            x2 = mouseEvent.getX();
            rectan = new Rectan(Color.DARKORANGE, 40, 1, x2, 0);
            rectan.draw(gr);
            key++;
        }
        if (key == 4){
            if(x1-x2 < 0){
                rectan = new Rectan(Color.GOLD, 40, Math.abs(x1-x2), x1, 0);
                rectan.draw(gr);
            }
            else{
                rectan = new Rectan(Color.GOLD, 40, Math.abs(x1-x2), x2, 0);
                rectan.draw(gr);
            }
            setTextFieldsByTime(getTimePoint(x1), getTimePoint(x2), from, to);
            key = -1;
            x2 = 0;
        }
        key++;
        this.rectan = rectan;
    }

    /**
     * Этот метод возвращает последнее сохраненное значение объекта фигуры (задачи).
     * @return Объект фигуры для отображения задачи.
     */
    public Rectan getRectan(){
        return this.rectan;
    }

    /**
     * Этот метод возвращает последнее сохраненное значение объекта гоафического буфера.
     * @return Объект графического буфера.
     */
    public GraphicsContext getGraphicContent(){
        return this.gr;
    }

}
