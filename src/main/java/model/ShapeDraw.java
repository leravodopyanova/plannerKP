package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Абстрактный класс, реализующий структуру построения графических фигур.
 * @author Водопьянова Валерия
 * @version 1.1
 */

public abstract class ShapeDraw {
    private double x;
    private double y;
    private Color color;
    private double width;
    private double length;

    // объявление абстрактных методов

    /**
     * Абстрактный метод для получения площади фигуры.
     * @return Значение площади фигуры.
     */
    abstract double area();

    /**
     * Абстрактный метод для преобразования фигуры в строку.
     * @return Строковое значение фигуры.
     */
    public abstract String toString();

    /**
     * Абстрактный метод для реализации рисования фигуры.
     * @param gr Параметр графического буфера для рисования фигур.
     */
    public abstract void draw(GraphicsContext gr);

    /**
     * Абстрактный метод для получения ширины фигуры.
     * @return Значение ширины фигуры.
     */
    public abstract double getWidth();

    /**
     * Абстрактный метод для получения ширины фигуры.
     * @return Значение высоты фигуры.
     */
    public abstract double getLength();

    /**
     * Конструктор, задающий параметры фигуры: цвет, высоту, ширину, координаты х и у.
     * @param color Параметр цвета заливки фигуры.
     * @param length Параметр высоты фигуры.
     * @param width Параметр ширины фигуры.
     * @param x Значение координаты х точки начала построения фигуры.
     * @param y Значение координаты у точки начала построения фигуры.
     */
    public ShapeDraw(Color color, double length, double width, double x, double y) {
        // calling ShapeDraw constructor
        this.color = color;
        this.length = length;
        this.width = width;
        this.x = x;
        this.y = y;
    }

    /**
     * Конструктор класса, задающий цвет фигуры color.
     * @see Color
     */
    public ShapeDraw(Color color) {
        System.out.println("ShapeDraw constructor called");
        this.color = color;
    }

    /**
     * Этот метод получает координату Х фигуры.
     * @return Значение координаты Х фигуры.
     */
    public double getX() {
        return x;
    }

    /**
     * Этот метод для задания параметра координаты Х точки начала построения фигуры.
     * @param x Заданный параметр координаты Х точки начала построения фигуры.
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Этот метод получает координату Y фигуры.
     * @return Значение координаты Y фигуры.
     */
    public double getY() {
        return y;
    }

    /**
     * Этот метод для задания параметра координаты Y точки начала построения фигуры.
     * @param y Заданный параметр координаты Y точки начала построения фигуры.
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Этот метод для задания параметра цвета фигуры.
     * @param color Заданный параметр цвета фигуры.
     */
    public void setColor(Color color) {
        this.color=color;
    }

}
