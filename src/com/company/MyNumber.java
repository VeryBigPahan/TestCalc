package com.company;

import java.util.Objects;

public class MyNumber {
    private String numsys = "na";
    private String value;

    public void setValue(String value) {
        this.value = value;
        boolean isroman = true;
        boolean isnumber = true;
        try{
            RomNum.valueOf(value);
        } catch (IllegalArgumentException e)    {
            isroman = false;
        }
        if (isroman == false){
            try {
                Integer.parseInt(value);
            } catch (NumberFormatException e)   {
                isnumber = false;
            }
            if (isnumber == true) {
                for (int i = 1; i < 11; i++) {
                    if (i == Integer.parseInt(value)) {
                        numsys = "arabic";
                        break;
                    } else {
                        numsys = "na";
                    }
                }
            }
            else {
                numsys = "na";
                }
            }
        else{
            numsys = "roman";
        }
    }

    public int getValue() {
        if (Objects.equals(numsys, "arabic")) {
            return Integer.parseInt(value);
        }
        else{
            switch (value){
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

    public String getNumsys() {
        return numsys;
    }

    public void setNumsys(String numsys) {
        this.numsys = numsys;
    }




}
