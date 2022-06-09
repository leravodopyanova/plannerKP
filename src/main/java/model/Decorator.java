package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Абстрактный класс, наследующий реализацию ShapeDraw в рамках паттерна Декоратор.
 * @author Водопьянова Валерия
 * @version 1.1
 * @see ShapeDraw
 */

public abstract class Decorator extends ShapeDraw {
    protected ShapeDraw shapeDraw;
    private Color color;

    /**
     * Конструктор класса, задающий значения фигуры для декора shapeDraw и цвета фигуры color.
     * @param shapeDraw Объект фигуры для декора.
     * @param color Цвет фигуры.
     * @see Color
     */
    public Decorator(ShapeDraw shapeDraw, Color color){
        super(Color.TRANSPARENT);
        this.color = color;
        this.shapeDraw = shapeDraw;
    }

    /**
     * Конструктор класса, задающий цвет фигуры color.
     * @see Color
     */
    public Decorator() {
        super(Color.ALICEBLUE);
    }

    /**
     * Конструктор класса, задающий значения фигуры для декора shapeDraw.
     * @param shapeDraw Объект фигуры для декора.
     */
    public Decorator(ShapeDraw shapeDraw) {
        super(Color.TRANSPARENT);
    }

    /**
     * Этот метод выполняет зарисовку фигуры shapeDraw.
     * @param gr Объект, задающий графический буфер для вывода графических объектов.
     * @see GraphicsContext
     */
    @Override
    public void draw(GraphicsContext gr){
        shapeDraw.draw(gr);
    }
}
