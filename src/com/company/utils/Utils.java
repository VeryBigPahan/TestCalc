package com.company.utils;

import java.util.List;


public class Utils {

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
}
