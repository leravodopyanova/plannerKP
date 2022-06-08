package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class Textt extends Decorator{
    String txt;
    private Color color;

    public Textt(ShapeDraw shapeDraw, String txt, Color color) {
        super(shapeDraw);
        this.shapeDraw = shapeDraw;
        this.txt = txt;
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
        gr.setStroke(color);
        gr.setFont(Font.font("Times New Roman", 10));
        gr.setTextAlign(TextAlignment.RIGHT);
        gr.strokeText(txt, shapeDraw.getX()+shapeDraw.getWidth(), 20, shapeDraw.getWidth());
    }

    @Override
    public double getWidth() {
        return 0;
    }

    @Override
    public double getLength() {
        return 0;
    }
}

