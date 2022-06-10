package model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Класс, реализующий тестирование класса Calculation.
 * @author Водопьянова Валерия
 * @version 1.1
 * @see Calculation
 */
class CalculationTest {
    Calculation calculation;
    @BeforeEach
    void setUp() {
        calculation = new Calculation();
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * Этот метод тестирует определения времени для отрезка.
     */
    @Test
    @DisplayName("проверка определения времени для отрезка")
    void getTimeSubj_min() {
        Assertions.assertEquals(22, calculation.getTimeSubj_min(10, 20), "проверка определения времени для отрезка не выполнена");
    }

    /**
     * Этот метод тестирует определения времени в формате чч:мм для отрезка.
     */
    @Test
    @DisplayName("проверка определения времени в формате чч:мм для отрезка")
    void getTimeSubjAllTime() {
        Assertions.assertEquals("0:22", calculation.getStringFullTimeSubj(10, 20), "проверка определения времени для отрезка в формате чч:мм не выполнена");
    }

    /**
     * Этот метод тестирует определения времени в мин для точки отрезка.
     */
    @Test
    @DisplayName("проверка определения времени в мин для точки отрезка")
    void getTimePointInMinutes() {
        Assertions.assertEquals(224, calculation.getTimePointInMinutes(100), "проверка определения времени в мин для точки отрезка");
    }

    /**
     * Этот метод тестирует определения времени в формате чч:мм для точки отрезка.
     */
    @Test
    @DisplayName("проверка определения времени в формате чч:мм для точки отрезка")
    void getTimePoint() {
        Assertions.assertEquals("3:44", calculation.getTimePoint(100), "проверка определения времени для точки отрезка в формате чч:мм не выполнена");
    }
}