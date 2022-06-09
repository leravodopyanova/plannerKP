package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

/**
 * Класс, описывающий одну из реализаций декора фигуры - <b>Добавление текста на фигуру</b>.
 * <p>
 *     Декор накладывается на построенную раннее фигуру.
 * </p>
 * @author Водопьянова Валерия
 * @version 1.1
 */
public class Textt extends Decorator{
    String txt;
    private Color color;

    /**
     * Конструктор класса, задающий значения фигуры для декора shapeDraw, текста txt и цвета color.
     * @param shapeDraw Объект фигуры для декора.
     * @param color Цвет заливки фигуры.
     * @see Color
     */
    public Textt(ShapeDraw shapeDraw, String txt, Color color) {
        super(shapeDraw);
        this.shapeDraw = shapeDraw;
        this.txt = txt;
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
        return null;
    }

    /**
     * Этот метод выполняет написание текста на фигуре shapeDraw.
     * @param gr Объект, задающий графический буфер для вывода графических объектов.
     * @see GraphicsContext
     */
    @Override
    public void draw(GraphicsContext gr){
        gr.setStroke(color);
        gr.setFont(Font.font("Times New Roman", 10));
        gr.setTextAlign(TextAlignment.RIGHT);
        gr.strokeText(txt, shapeDraw.getX()+shapeDraw.getWidth(), 20, shapeDraw.getWidth());
    }

    /**
     * Этот метод получает ширину фигуры shapeDraw.
     * @return Значение ширины фигуры shapeDraw.
     */
    @Override
    public double getWidth() {
        return 0;
    }

    /**
     * Этот метод получает высоту фигуры shapeDraw.
     * @return Значение высоту фигуры shapeDraw.
     */
    @Override
    public double getLength() {
        return 0;
    }
}

