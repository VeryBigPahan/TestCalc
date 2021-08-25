package com.company;

public enum RomNum {
    I("I"), II("II"), III("III"), IV("IV"), V("V"), VI("VI"), VII("VII"), VIII("VIII"), IX("IX"), X("X");

    private String roman;

    RomNum(String roman){
        this.roman = roman;
    }
}
