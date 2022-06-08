package model;

import org.junit.jupiter.api.*;

class CalculationTest {
    Calculation calculation;
    @BeforeEach
    void setUp() {
        calculation = new Calculation();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    @DisplayName
            ("Проверка количества минут по двум координатам Х")
    void getTimeSubj_min() {
        Assertions.assertEquals(22, calculation.getTimeSubj_min(20, 10));
    }

    @Test
    @DisplayName
            ("Проверка получения строки чч:мм по двум координатам Х (минут > 10)")
    void getTimeSubjAllTime() {
        Assertions.assertEquals(0, calculation.getTimeSubj_min(20, 10)/60, "Проверка часов");
        Assertions.assertEquals(22, calculation.getTimeSubj_min(20, 10)%60, "Проверка минут");
        Assertions.assertEquals("0:22", (calculation.getTimeSubjAllTime(20, 10)), "Проверка получения всей строки времени (минут > 10)");
        Assertions.assertEquals("0:09", (calculation.getTimeSubjAllTime(0, 4)), "Проверка получения всей строки времени (минут <= 10)");
    }

    @Test
    @DisplayName
            ("Проверка получения строки чч:мм в точке с координатой Х")
    void getTimePointInMinutes() {
        Assertions.assertEquals(22, calculation.getTimePointInMinutes(10), "Проверка минут в точке");
    }

    @Test
    @DisplayName
            ("Проверка количества минут по двум координатам Х (минут > 10)")
    void getTimePoint() {
        Assertions.assertEquals(0, calculation.getTimeSubj_min(20, 10)/60, "Проверка часов");
        Assertions.assertEquals(22, calculation.getTimeSubj_min(20, 10)%60, "Проверка минут");
        Assertions.assertEquals("0:22", (calculation.getTimePoint(10)), "Проверка получения всей строки времени (минут > 10)");
        Assertions.assertEquals("0:09", (calculation.getTimePoint(4)), "Проверка получения всей строки времени (минут <= 10)");
    }
}