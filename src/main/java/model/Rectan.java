package model;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectan extends ShapeDraw {
    double length;
    double width;
    double x;
    double y;
    Color color;

    public Rectan(Color color, double length, double width, double x, double y) {
        // calling ShapeDraw constructor
        super(color);
        this.color = color;
        this.length = length;
        this.width = width;
        this.x = x;
        this.y = y;
    }

    @Override
    double area() {
        return length*width;
    }
    public double getX() {
        return x;
    }
    public double getWidth() {
        return width;
    }
    public double getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "Цвет прямоугольника - " + color +  " и его площадь : " + area();
    }

    @Override
    public void draw(GraphicsContext gr){
        gr.setFill(color);
        gr.setStroke(Color.ORANGE);
        gr.fillRect(x, y, width, length);
    }
}
