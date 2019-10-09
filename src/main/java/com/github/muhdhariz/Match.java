package com.github.muhdhariz;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Match {

    boolean isMatch(String pattern, String link) {

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(link);
        return m.find();

    }

    public static void main(String[] args) {
        //example||test
        String myString = " https://github.com";
        String myLink = "https://github.com/muhdhariz";

        Boolean result = new Match().isMatch(myString, myLink);
        System.out.println(result);
    }
}
