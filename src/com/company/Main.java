package com.company;

import javax.swing.*;
import java.util.Objects;
import java.util.Scanner;

import static com.company.Utils.ARA_TO_ROM;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String eq = in.nextLine();
        eq = eq.trim();
        String[] parts = eq.split(" ");
        int el = parts.length;
        if (el == 1){
            System.out.print("Не является математической операцией");
        }
        else if (el != 3) {
            System.out.print("Слишком много операндов и/или операторов");
        }
        else {
            String p1 = parts[0];
            String p2 = parts[1];
            String p3 = parts[2];
            MyNumber n1 = new MyNumber();
            MyNumber n2 = new MyNumber();
            n1.setValue(p1);
            n2.setValue(p3);
            int v1 = n1.getValue();
            int v2 = n2.getValue();
            String s1 = n1.getNumsys();
            String s2 = n2.getNumsys();
            int result;
            if (Objects.equals(s1, "na") || Objects.equals(s2, "na")) {
                System.out.print("Введены некорректные числа");
            } else if (!Objects.equals(s1, s2)) {
                System.out.print("Не совпадают системы счисления");
            } else if (Objects.equals(s1, "arabic")) {
                switch (p2) {
                    case "-":
                        System.out.println(v1 - v2);
                        break;
                    case "+":
                        System.out.println(v1 + v2);
                        break;
                    case "*":
                        System.out.println(v1 * v2);
                        break;
                    case "/":
                        System.out.println(v1 / v2);
                        break;
                    default:
                        System.out.print("Неверный тип операции");
                }
            } else {
                switch (p2) {
                    case "-":
                        result = v1 - v2;
                        if (result == 0) {
                            System.out.print("В римской системе нет 0");
                        } else if (result < 0) {
                            System.out.print("В римской системе нет отрицательных чисел");
                        } else {
                            System.out.println(ARA_TO_ROM.get(result));
                        }
                        break;
                    case "+":
                        result = v1 + v2;
                        if (result > 10){
                            System.out.printf("Очень большое римское число( %d - арабский вариант)", result);
                        }
                        else {
                            System.out.println(ARA_TO_ROM.get(result));
                        }
                        break;
                    case "*":
                        result = v1 * v2;
                        if (result > 10){
                            System.out.printf("Очень большое римское число( %d - арабский вариант)", result);
                        }
                        else {
                            System.out.println(ARA_TO_ROM.get(result));
                        }
                        break;
                    case "/":
                        result = v1 / v2;
                        if (result == 0) {
                            System.out.print("В римской системе нет 0");
                        }
                        else {
                            System.out.println(ARA_TO_ROM.get(result));
                        }
                        break;
                    default:
                        System.out.print("Неверный тип операции");
                        break;
                }
            }
        }
    }
}