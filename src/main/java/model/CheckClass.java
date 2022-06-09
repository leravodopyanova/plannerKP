package model;

/**
 * Класс, выполняющий преобразование данных в удобные для понимания пользователем.
 * @author Водопьянова Валерия
 * @version 1.1
 */

public class CheckClass {
    /**
     * Этот метод преобразует булевую переменную check в соответствующее символьное значение.
     * @param check Значение статуса выполнения задачи.
     * @return Символ, соответствующий заданному параметру check.
     */
    public String checkStatus(Boolean check){
        if(check.equals(false)){
            return "Х";
        }
        else{
            return "V";
        }
    }
}
