package com.company.utils;

import com.company.exception.Messages;
import com.company.exception.RomanNumberFormatException;

import java.util.List;


public class Utils {

    public static final int MIN_NUMBER = 0;
    public static final int MAX_NUMBER = 10;

    public static String arabicToRoman(int number) {

        List<AraToRom> romanNumerals = AraToRom.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNumerals.size())) {
            AraToRom currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getRomvalue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getRomvalue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }

    public static int romanToArabic(String input) {
        String romanNumeral = input.toUpperCase();
        int result = 0;

        List<AraToRom> romanNumerals = AraToRom.getReverseSortedValues();

        int i = 0;

        while ((romanNumeral.length() > 0) && (i < romanNumerals.size())) {
            AraToRom symbol = romanNumerals.get(i);
            if (romanNumeral.startsWith(symbol.name())) {
                result += symbol.getRomvalue();
                romanNumeral = romanNumeral.substring(symbol.name().length());
            } else {
                i++;
            }
        }

        if (romanNumeral.length() > 0) {
            throw new RomanNumberFormatException(String.format(Messages.ARABIAN_CAN_NOT_PARSE_TO_ROMAN, input));
        }

        return result;
    }
}
