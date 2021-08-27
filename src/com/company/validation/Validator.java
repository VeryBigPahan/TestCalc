package com.company.validation;

import com.company.number.MyNumber;
import com.company.exception.ArabianNumberException;
import com.company.exception.ExpressionException;
import com.company.exception.Messages;
import com.company.utils.Utils;

public class Validator {

    public void validateExpression(int partsCount) {
        if (partsCount == 1) {
            throw new ExpressionException(Messages.INVALID_OPERATION);
        } else if (partsCount != 3) {
            throw new ExpressionException(Messages.TOO_MANY_OPERATORS);
        }
    }

    public void validateNumberSys(String firstNumberNumsys, String secondNumberNumsys) {
        if (MyNumber.INCORRECT_NUMBER_SYS.equals(firstNumberNumsys) || MyNumber.INCORRECT_NUMBER_SYS.equals(secondNumberNumsys)) {
            throw new ExpressionException(Messages.INCORRECT_NUMBERS);
        } else if (!firstNumberNumsys.equals(secondNumberNumsys)) {
            throw new ExpressionException(Messages.INCORRECT_NUMBERS_SYS);
        }
    }

    public void validateRomanNumbers(int result, String operation) {
        switch (operation) {
            case "-":
                if (result == 0) {
                    throw new ExpressionException(Messages.ROMAN_HAS_NOT_ZERO_NUMBER);
                } else if (result < 0) {
                    throw new ExpressionException(Messages.ROMAN_HAS_NOT_NEGATIVE_NUMBERS);
                }
                break;
            case "+":
            case "*":
            case "/":
                if (result == 0) {
                    throw new ExpressionException(Messages.ROMAN_HAS_NOT_ZERO_NUMBER);
                }
                break;
            default:
                throw new ExpressionException(Messages.INVALID_OPERATION_TYPE);
        }
    }

    public void validateArabianNumbers(int firstNumberValue, int secondNumberValue) {
        if ((firstNumberValue < Utils.MIN_NUMBER || firstNumberValue > Utils.MAX_NUMBER)
                || (secondNumberValue < Utils.MIN_NUMBER || secondNumberValue > Utils.MAX_NUMBER)) {
            throw new ArabianNumberException(Messages.ARABIAN_NUMBER_INCORRECT);
        }
    }
}
