package com.company;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String inputString;
        Pattern p = Pattern.compile("\\d+\\s[+,\\-, *, %, /, ^]\\s\\d+"); //класс для чтения регулярного выражения
        Matcher m; //перебирает последовательно символы, пока не встретит совпадение с шаблоном
        double result = 0;
        System.out.println("Введите пример: ");
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                if (scanner.hasNextLine()) {
                    inputString = scanner.nextLine();
                    m = p.matcher(inputString);
                    if (m.find()) {
                        result = split(inputString.split(" "), result);
                        System.out.println(result);
                        return;
                    } else {
                        System.out.println("Ввод не корректен!");
                        return;
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * метод для работы с введенной пользователем строкой и поиска в нем нужных значений
     *
     * @param array массив для разрыва строки на значения, необходимый для длальнейшей работы с ними
     * @param previousResult переменная проверяющая предыдущий результат
     * @return возвращает значения для возможности их дальнейшего использования методе calculate
     * @throws Exception обрабатывает исключения
     */
    private static double split(String[] array, double previousResult) throws Exception {
        String operand;
        double number1;
        double number2;
        if (array.length == 3) {
            number1 = Double.parseDouble(array[0]);
            operand = array[1];
            number2 = Double.parseDouble(array[2]);
            return calculate(number1, number2, operand);
        } else {
            throw new Exception("Ввод не корректен");
        }
    }

    /**
     * метод для реализации базовых функций калькулятора
     * @param number1 значение 1
     * @param number2 значение 2
     * @param operand действие, которое должно быть применено к значению
     * @return возвращает результат действия
     * @throws Exception обрабатывает исключения
     */
    private static double calculate(double number1, double number2, String operand) throws Exception {
        switch (operand) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "/":
                return number1 / number2;
            case "^":
                return Math.pow(number1, number2);
            case "%":
                return number1 % number2;
            default:
                throw new Exception("Ввод не корректен");
        }
    }
}