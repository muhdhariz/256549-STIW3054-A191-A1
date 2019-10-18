package com.github.muhdhariz;

import java.util.*;

public class Compare {
    private static int totalCommented = 0, totalNotCommented = 0, totalAnonCommented = 0;
    private static String[] matL = new String[38], matC = new String[38];
    static String[][] studS = new String[38][4], studU = new String[38][4], studNS = new String[38][3];

    public static void main(String[] args) {
        new studentList();
        studentList.main(args);
        new studentComment();
        studentComment.main(args);

        for (int i = 0; i < studentList.sL.length; i++) {
            matL[i] = studentList.sL[i][0];
        }

        for (int i = 0; i < studentComment.sS.length; i++) {
            matC[i] = studentComment.sS[i][0];
        }

        for (int i = 0; i < studentComment.sS.length; i++) {
            if (Arrays.asList(matL).contains(studentComment.sS[i][0]) && !studentComment.sS[i][0].equals(" ")) {
                studS[totalCommented][0] = String.valueOf(totalCommented + 1);
                studS[totalCommented][1] = studentComment.sS[i][0];
                studS[totalCommented][2] = studentComment.sS[i][1];
                studS[totalCommented][3] = studentComment.sS[i][2];
                totalCommented++;
            } else if (!Arrays.asList(matL).contains(studentComment.sS[i][0]) && !studentComment.sS[i][0].equals(" ")) {
                studU[totalAnonCommented][0] = String.valueOf(totalAnonCommented + 1);
                studU[totalAnonCommented][1] = studentComment.sS[i][0];
                studU[totalAnonCommented][2] = studentComment.sS[i][1];
                studU[totalAnonCommented][3] = studentComment.sS[i][2];
                totalAnonCommented++;
            }
        }

        for (int i = 0; i < studentList.sL.length; i++) {
            if (!Arrays.asList(matC).contains(studentList.sL[i][0]) && studentList.sL[i][0] != null && !studentList.sL[i][0].equals("254660")) {
                studNS[totalNotCommented][0] = String.valueOf(totalNotCommented + 1);
                studNS[totalNotCommented][1] = studentList.sL[i][0];
                studNS[totalNotCommented][2] = studentList.sL[i][1];
                totalNotCommented++;
            }
        }
    }
}
