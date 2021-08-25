package com.company;

import java.util.Objects;

public class MyNumber {

    public static final String INCORRECT_NUMBER_SYS = "na";
    public static final String ARABIAN_NUMBER_SYS = "arabic";
    public static final String ROMAN_NUMBER_SYS = "roman";

    private String numsys;
    private String value;

    public MyNumber(String value) {
        setValue(value);
    }

    public int getValue() {
        if (Objects.equals(numsys, ARABIAN_NUMBER_SYS)) {
            return Integer.parseInt(value);
        } else {
            switch (value) {
                case "I":
                    return 1;
                case "II":
                    return 2;
                case "III":
                    return 3;
                case "IV":
                    return 4;
                case "V":
                    return 5;
                case "VI":
                    return 6;
                case "VII":
                    return 7;
                case "VIII":
                    return 8;
                case "IX":
                    return 9;
                case "X":
                    return 10;
                default:
                    return 0;
            }
        }
    }

    public void setValue(String value) {
        this.value = value;
        boolean isroman = true;
        boolean isnumber = true;
        try {
            RomNum.valueOf(value);
        } catch (IllegalArgumentException e) {
            isroman = false;
        }
        if (!isroman) {
            try {
                Integer.parseInt(value);
            } catch (NumberFormatException e) {
                isnumber = false;
            }
            if (isnumber) {
                for (int i = 1; i < 11; i++) {
                    if (i == Integer.parseInt(value)) {
                        numsys = ARABIAN_NUMBER_SYS;
                        break;
                    } else {
                        numsys = INCORRECT_NUMBER_SYS;
                    }
                }
            } else {
                numsys = INCORRECT_NUMBER_SYS;
            }
        } else {
            numsys = ROMAN_NUMBER_SYS;
        }
    }

    public String getNumsys() {
        return numsys;
    }

}
