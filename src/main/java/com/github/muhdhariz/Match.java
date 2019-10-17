package com.github.muhdhariz;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Match {
    private static String name = "", matric = "", github = "";

    boolean isMatch(String pattern, String link) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(link);
        return m.find();
    }

    public static void main(String[] args) {
        //example||test
        String myString = "[0-9]";
        String myLink = "Muhammad Hariz bin Mohd Hafidz";

        Boolean result = new Match().isMatch(myString, myLink);
        System.out.println(result);
    }
}
