package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Decorator extends ShapeDraw {
    protected ShapeDraw shapeDraw;
    private Color color;

    public Decorator(ShapeDraw shapeDraw, Color color){
        super(Color.TRANSPARENT);
        this.color = color;
        this.shapeDraw = shapeDraw;
    }

    public Decorator() {
        super(Color.ALICEBLUE);
    }

    public Decorator(ShapeDraw shapeDraw) {
        super(Color.TRANSPARENT);
    }

    @Override
    public void draw(GraphicsContext gr){
        shapeDraw.draw(gr);
    }
}
