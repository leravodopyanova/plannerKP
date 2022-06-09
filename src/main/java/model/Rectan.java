package model;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Класс, реализующий прорисовку объекта в виде прямоугольника на диаграмме.
 * <p>
 *     Наследует реализацию абстрактного класса ShapeDraw.
 * </p>
 * @author Водопьянова Валерия
 * @version 1.1
 * @see ShapeDraw
 */

public class Rectan extends ShapeDraw {
    double length;
    double width;
    double x;
    double y;
    Color color;

    /**
     * Конструктор класса Rectan, задающий цвет, высоту, ширину, координаты х и у.
     * @param color Значение цвета фигуры.
     * @param length Значение высоты фигуры.
     * @param width Значение ширины фигуры.
     * @param x Значение параметра координаты x фигуры.
     * @param y Значение параметра координаты у фигуры.
     */
    public Rectan(Color color, double length, double width, double x, double y) {
        // calling ShapeDraw constructor
        super(color);
        this.color = color;
        this.length = length;
        this.width = width;
        this.x = x;
        this.y = y;
    }

    /**
     * Этот метод вычисляет площадь фигуры.
     * @return Значение площади фигуры.
     */
    @Override
    double area() {
        return length*width;
    }
    /**
     * Этот метод получает координату Х фигуры.
     * @return Значение координаты Х фигуры.
     */
    public double getX() {
        return x;
    }

    /**
     * Этот метод получает ширину фигуры.
     * @return Значение ширины фигуры.
     */
    public double getWidth() {
        return width;
    }

    /**
     * Этот метод получает длину фигуры.
     * @return Значение длины фигуры.
     */
    public double getLength() {
        return length;
    }

    /**
     * Этот метод преобразует фигуру в строку.
     * @return Значение преобразованной строки.
     */
    @Override
    public String toString() {
        return "Цвет прямоугольника - " + color +  " и его площадь : " + area();
    }

    /**
     * Этот метод выполняет прорисовку фигуры прямоугольника.
     * @param gr Объект, задающий графический буфер для вывода графических объектов.
     * @see GraphicsContext
     */
    @Override
    public void draw(GraphicsContext gr){
        gr.setFill(color);
        gr.setStroke(Color.ORANGE);
        gr.fillRect(x, y, width, length);
    }
}
