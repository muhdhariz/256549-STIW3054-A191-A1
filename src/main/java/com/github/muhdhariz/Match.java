package com.github.muhdhariz;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Match {
    boolean isMatch(String pattern, String link) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(link);
        return m.find();
    }
}
