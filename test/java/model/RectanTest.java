package model;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Класс, реализующий тестирование класса Rectan.
 * @author Водопьянова Валерия
 * @version 1.1
 * @see Rectan
 */
class RectanTest {
    Rectan rectan;

    @BeforeEach
    void setUp() {
        rectan = new Rectan(Color.ALICEBLUE, 100, 200, 10, 0);
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * Этот метод тестирует определения площади прямоугольника.
     */
    @Test
    @DisplayName("проверка определения площади прямоугольника")
    void area() {
        Assertions.assertEquals(20000, rectan.area(), "площадь фигуры определена неверно");
    }
    /**
     * Этот метод тестирует  преобразования фигуры в строку.
     */
    @Test
    @DisplayName("проверка преобразования фигуры в строку")
    void testToString() {
        Assertions.assertEquals("Цвет прямоугольника - 0xf0f8ffff и его площадь : 20000.0", rectan.toString(), "преобразование фигуры в строку выполнено неверно");
    }
}