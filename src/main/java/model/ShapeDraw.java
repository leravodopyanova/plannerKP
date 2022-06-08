package model;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class ShapeDraw {
    private double x;
    private double y;
    //параметры фигуры - приватные поля
    private Color color;
    private double width;
    private double length;

    // объявление абстрактных методов
    abstract double area();
    public abstract String toString();
    public abstract void draw(GraphicsContext gr);

    // конструктор
    public ShapeDraw(Color color, double length, double width, double x, double y) {
        // calling ShapeDraw constructor
        this.color = color;
        this.length = length;
        this.width = width;
        this.x = x;
        this.y = y;
    }
    public ShapeDraw(Color color) {
        System.out.println("ShapeDraw constructor called");
        this.color = color;
    }

    public double getX() {
        return x;
    }
    public abstract double getWidth();
    public abstract double getLength();

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    // реализация методов
    public void setColor(Color color) {
        this.color=color;
    }

}
