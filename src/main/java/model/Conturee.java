package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Класс, описывающий одну из реализаций декора фигуры - <b>Заливка фигуры</b>.
 * <p>
 *     Декор накладывается на построенную раннее фигуру.
 * </p>
 * @author Водопьянова Валерия
 * @version 1.1
 */

public class Conturee extends Decorator{
    private ShapeDraw shapeDraw;
    private Color color;

    /**
     * Конструктор класса, задающий значения фигуры для декора shapeDraw и цвета color для заливки.
     * @param shapeDraw Объект фигуры для декора.
     * @param color Цвет заливки фигуры.
     * @see Color
     */
    public Conturee(ShapeDraw shapeDraw, Color color) {
        super(shapeDraw);
        this.shapeDraw = shapeDraw;
        this.color = color;
    }

    /**
     * Этот метод вычисляет площадь фигуры.
     * @return Значение площади фигуры.
     */
    @Override
    double area() {
        return 0;
    }

    /**
     * Этот метод преобразует фигуру в строку.
     * @return Значение преобразованной строки.
     */
    @Override
    public String toString() {
        return "Заливка фигуры " + shapeDraw.toString() + "цветом " + color.toString();
    }

    /**
     * Этот метод выполняет заливку фигуры shapeDraw.
     * @param gr Объект, задающий графический буфер для вывода графических объектов.
     * @see GraphicsContext
     */
    @Override
    public void draw(GraphicsContext gr){
        gr.setFill(color);
        gr.fillRect(shapeDraw.getX(), shapeDraw.getY(), shapeDraw.getWidth(), shapeDraw.getLength());
    }

    /**
     * Этот метод получает ширину фигуры shapeDraw.
     * @return Значение ширины фигуры shapeDraw.
     */
    @Override
    public double getWidth() {
        return shapeDraw.getWidth();
    }

    /**
     * Этот метод получает высоту фигуры shapeDraw.
     * @return Значение высоту фигуры shapeDraw.
     */
    @Override
    public double getLength() {
        return shapeDraw.getLength();
    }
}
