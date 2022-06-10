package model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Класс, реализующий тестирование класса CheckClass.
 * @author Водопьянова Валерия
 * @version 1.1
 * @see CheckClass
 */
class CheckClassTest {
    CheckClass checkClass;
    @BeforeEach
    void setUp() {
        checkClass = new CheckClass();
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * Этот метод тестирует получения символа по статусу выполнения задачи.
     */
    @Test
    @DisplayName("проверка получения символа по статусу выполнения задачи")
    void checkStatus() {
        Assertions.assertEquals("V", checkClass.checkStatus(true), "символ по статусу выполнения задачи получен неправильно");
    }
}