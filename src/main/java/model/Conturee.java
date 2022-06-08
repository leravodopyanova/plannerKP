package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Conturee extends Decorator{
    private ShapeDraw shapeDraw;
    private Color color;

    public Conturee(ShapeDraw shapeDraw, Color color) {
        super(shapeDraw);
        this.shapeDraw = shapeDraw;
        this.color = color;
    }

    @Override
    double area() {
        return 0;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public void draw(GraphicsContext gr){
        gr.setFill(color);
        gr.fillRect(shapeDraw.getX(), shapeDraw.getY(), shapeDraw.getWidth(), shapeDraw.getLength());
    }

    @Override
    public double getWidth() {
        return shapeDraw.getWidth();
    }

    @Override
    public double getLength() {
        return shapeDraw.getLength();
    }
}
