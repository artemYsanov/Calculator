package com.company;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        /**
         *@see Math.pow(num1,num2) - Метод для возведения в степень.
         * В задаче требуется работать с целыми числами, но метод "Math.pow" работает только с переменными double.
         */
    double num1;
    double num2;
    double equally;
    char sign;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите первое число:");
        num1 = scanner.nextDouble();
        System.out.print("Введите один из знаков операции (+, -, *, /, %, ^):");
        sign = scanner.next().charAt(0);
        System.out.print("Введите второе число:");
        num2 = scanner.nextDouble();
        switch(sign) {
            case '+':
                equally = num1 + num2;
                break;
            case '-':
                equally = num1 - num2;
                break;
            case '*':
                equally = num1 * num2;
                break;
            case '%':
                equally = num1 % num2;
                break;
            case '^':
                equally = Math.pow(num1,num2);
                break;
            case '/':
                equally = num1 / num2;
                break;
            default:
                System.out.printf("Error!");
                return;
        }
        System.out.println(equally);
    }

}
