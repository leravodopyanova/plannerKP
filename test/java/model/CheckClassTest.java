package model;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CheckClassTest {
    CheckClass checkClass;
    @BeforeEach
    void setUp() {
        checkClass = new CheckClass();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("проверка получения символа по статусу выполнения задачи")
    void checkStatus() {
        Assertions.assertEquals("V", checkClass.checkStatus(true), "символ по статусу выполнения задачи получен неправильно");
    }
}