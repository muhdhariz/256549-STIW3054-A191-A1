package com.github.muhdhariz;

import java.util.*;

public class Comparison {
    private static int totalCommented = 0, totalNotCommented = 0, totalAnonCommented = 0;
    private static String[] matL = new String[38], matC = new String[38], report = new String[38], rePrint = new String[38];
    private static String[] Title = {"No.", "Matric", "Name", "Github Link"};
    static String[][] studS = new String[38][4], studU = new String[38][4], studNS = new String[38][4];

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
                studS[0] = Title;
                studS[totalCommented + 1][0] = String.valueOf(totalCommented + 1);
                studS[totalCommented + 1][1] = studentComment.sS[i][0];
                studS[totalCommented + 1][2] = studentComment.sS[i][1];
                studS[totalCommented + 1][3] = studentComment.sS[i][2];
                totalCommented++;
            } else if (!Arrays.asList(matL).contains(studentComment.sS[i][0]) && !studentComment.sS[i][0].equals(" ")) {
                studU[0] = Title;
                studU[totalAnonCommented + 1][0] = String.valueOf(totalAnonCommented + 1);
                studU[totalAnonCommented + 1][1] = studentComment.sS[i][0];
                studU[totalAnonCommented + 1][2] = studentComment.sS[i][1];
                studU[totalAnonCommented + 1][3] = studentComment.sS[i][2];
                totalAnonCommented++;
            } else if (!Arrays.asList(matC).contains(studentList.sL[i][0]) && studentList.sL[i][0] != null && !studentList.sL[i][0].equals("254660")) {
                studNS[0] = Title;
                studNS[totalNotCommented + 1][0] = String.valueOf(totalNotCommented + 1);
                studNS[totalNotCommented + 1][1] = studentList.sL[i][0];
                studNS[totalNotCommented + 1][2] = studentList.sL[i][1];
                totalNotCommented++;
            }
        }

        for (int i = 0; i < studentList.sL.length; i++) {
            if (!Arrays.asList(matC).contains(studentList.sL[i][0]) && studentList.sL[i][0] != null && !studentList.sL[i][0].equals("254660")) {
                studNS[0] = Title;
                studNS[totalNotCommented + 1][0] = String.valueOf(totalNotCommented + 1);
                studNS[totalNotCommented + 1][1] = studentList.sL[i][0];
                studNS[totalNotCommented + 1][2] = studentList.sL[i][1];
                totalNotCommented++;
            }
        }

        System.out.println("List of Student Submit");
        rePrint = report(studS);
        for (int i = 0; i < report.length; i++) {
            if (rePrint[i] != null) {
                System.out.println(rePrint[i]);
            }
        }
        clear(rePrint);
        System.out.println("\nList of Student Not Submit");
        rePrint = report(studNS);
        for (int i = 0; i < report.length; i++) {
            if (rePrint[i] != null) {
                System.out.println(rePrint[i]);
            }
        }
        clear(rePrint);
        System.out.println("\nList of Unknown Submit");
        rePrint = report(studU);
        for (int i = 0; i < report.length; i++) {
            if (rePrint[i] != null) {
                System.out.println(rePrint[i]);
            }
        }
    }

    private static String[] report(String[][] list) {
        for (int i = 0; i < list.length; i++) {
            if (i == 1) {
                report[i] = String.format("|%5s|%8s|%39s|%40s|", "-----", "--------", "---------------------------------------", "----------------------------------------");
            } else if (i == 0 && list[i][0] != null) {
                report[i] = String.format("| %-4s| %-7s| %-38s| %-39s|", list[i][0], list[i][1], list[i][2], list[i][3]);
            } else if (list[i - 1][0] != null) {
                report[i] = String.format("| %-4s| %-7s| %-38s| %-39s|", list[i - 1][0], list[i - 1][1], list[i - 1][2], list[i - 1][3]);
            }
        }
        return report;
    }

    private static void clear(String[] s) {
        Arrays.fill(s, null);
    }
}
