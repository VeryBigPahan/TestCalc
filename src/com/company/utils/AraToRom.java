package com.company.utils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum AraToRom {
    I(1), IV(4), V(5), IX(9), X(10), XL(40), L(50), XC(90), C(100);

    private final int romvalue;

    AraToRom(int romvalue) {
        this.romvalue = romvalue;
    }

    public static List<AraToRom> getReverseSortedValues() {
        return Arrays.stream(values())
                .sorted(Comparator.comparing((AraToRom e) -> e.romvalue).reversed())
                .collect(Collectors.toList());
    }

    public int getRomvalue() {
        return romvalue;
    }
}
