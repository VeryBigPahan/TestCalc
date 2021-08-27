package com.company.number;

import com.company.exception.RomanNumberFormatException;
import com.company.utils.Utils;

public class MyNumber {

    public static final String INCORRECT_NUMBER_SYS = "na";
    public static final String ARABIAN_NUMBER_SYS = "arabic";
    public static final String ROMAN_NUMBER_SYS = "roman";

    private String numsys;
    private int value;

    public MyNumber(String value) {
        setValue(value);
    }

    public int getValue() {
        return value;
    }

    public void setValue(String value) {
        boolean isRomanNumber = false;
        try {
            this.value = Utils.romanToArabic(value);
            isRomanNumber = true;
        } catch (RomanNumberFormatException romanNumberFormatException) {
            try {
                this.value = Integer.parseInt(value);
            } catch (NumberFormatException numberFormatException) {
                numsys = INCORRECT_NUMBER_SYS;
                return;
            }
        }

        numsys = isRomanNumber ? ROMAN_NUMBER_SYS : ARABIAN_NUMBER_SYS;
    }

    public String getNumsys() {
        return numsys;
    }

}
