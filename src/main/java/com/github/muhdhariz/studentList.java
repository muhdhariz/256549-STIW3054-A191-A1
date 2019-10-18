package com.github.muhdhariz;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class studentList {
    private static Match match = new Match();
    static String[][] sL = new String[38][2];
    private static int i = 0, j = 0;

    public static void main(String[] args) {
        new studentList().Main();
        for (int i = 0; i < sL.length; i++) {
            if (sL[i][0] == null && sL[i][1] == null) {
                sL[i][0] = " ";
                sL[i][1] = " ";
            }
        }
    }

    private void Main() {
        try {
            String ghLink = "https://github.com/STIW3054-A191/Assignments/wiki/List_of_Student";
            Document doc = Jsoup.connect(ghLink).get();

            //get info from studentComment
            Elements links = doc.getElementsByClass("markdown-body").select("td");

            for (Element link : links) {
                if (link.text().length() == 6 && match.isMatch("[0-9]", link.text()) && i < sL.length) {
                    sL[i][0] = link.text();
                    i++;
                } else if (match.isMatch("[a-zA-Z]", link.text()) && j < sL.length) {
                    sL[j][1] = link.text();
                    j++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
