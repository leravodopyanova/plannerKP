package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class DrawStudies extends Calculation{
    private final double Y1 = 0;
    private final double Y2 = 0;
    private double x1;
    private double x2;
    private int key = 0;
    private Rectan rectan;
    private GraphicsContext gr;

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

    public Rectan getRectan(){
        return this.rectan;
    }
    public GraphicsContext getGraphicContent(){
        return this.gr;
    }

}
