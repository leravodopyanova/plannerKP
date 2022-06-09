package model;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.*;

class RectanTest {
    Rectan rectan;

    @BeforeEach
    void setUp() {
        rectan = new Rectan(Color.ALICEBLUE, 100, 200, 10, 0);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("проверка определения площади прямоугольника")
    void area() {
        Assertions.assertEquals(20000, rectan.area(), "площадь фигуры определена неверно");
    }

    @Test
    @DisplayName("проверка преобразования фигуры в строку")
    void testToString() {
        Assertions.assertEquals("Цвет прямоугольника - 0xf0f8ffff и его площадь : 20000.0", rectan.toString(), "преобразование фигуры в строку выполнено неверно");
    }
}