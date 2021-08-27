package com.company;

import com.company.exception.ExpressionException;
import com.company.exception.Messages;
import com.company.number.MyNumber;
import com.company.utils.Utils;
import com.company.validation.Validator;

import java.util.Scanner;

public class Main {

    private final static String WELCOME_MESSAGE = "Введите выражение: ";
    private final static String SPACE = " ";
    private final static Validator validator = new Validator();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print(WELCOME_MESSAGE);

        String expression = in.nextLine();
        expression = expression.trim();
        String[] parts = expression.split(SPACE);

        validator.validateExpression(parts.length);

        String firstRawNumber = parts[0];
        String operation = parts[1];
        String secondRawNumber = parts[2];

        MyNumber firstNumber = new MyNumber(firstRawNumber);
        MyNumber secondNumber = new MyNumber(secondRawNumber);

        int firstNumberValue = firstNumber.getValue();
        int secondNumberValue = secondNumber.getValue();
        String firstNumberNumsys = firstNumber.getNumsys();
        String secondNumberNumsys = secondNumber.getNumsys();

        validator.validateNumberSys(firstNumberNumsys, secondNumberNumsys);

        if (MyNumber.ARABIAN_NUMBER_SYS.equals(firstNumberNumsys)) {
            System.out.println(evaluateArabianNumbers(operation, firstNumberValue, secondNumberValue));
        } else {
            System.out.println(evaluateRomanNumbers(operation, firstNumberValue, secondNumberValue));
        }
    }

    private static String evaluateRomanNumbers(String operation, int firstNumberValue, int secondNumberValue) {
        int result = evaluateArabianNumbers(operation, firstNumberValue, secondNumberValue);

        validator.validateRomanNumbers(result, operation);
        return Utils.arabicToRoman(result);
    }

    private static int evaluateArabianNumbers(String operation, int firstNumberValue, int secondNumberValue) {
        validator.validateArabianNumbers(firstNumberValue, secondNumberValue);

        int result;
        switch (operation) {
            case "-":
                result = firstNumberValue - secondNumberValue;
                break;
            case "+":
                result = firstNumberValue + secondNumberValue;
                break;
            case "*":
                result = firstNumberValue * secondNumberValue;
                break;
            case "/":
                result = firstNumberValue / secondNumberValue;
                break;
            default:
                throw new ExpressionException(Messages.INVALID_OPERATION_TYPE);
        }

        return result;
    }

}
