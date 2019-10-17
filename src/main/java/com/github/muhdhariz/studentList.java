package com.github.muhdhariz;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class studentList {
    private static Match match = new Match();
    private static String[][] sL = new String[35][2];
    public static void main(String[] args) {
        new studentList().Main();

        for (int i = 0; i < sL.length; i++) {
            for (int j = 0; j < sL[i].length; j++) {
                System.out.println(sL[i][j]);
            }
        }
    }

    private void Main() {
        try {
            String ghLink = "https://github.com/STIW3054-A191/Assignments/wiki/List_of_Student";
            Document doc = Jsoup.connect(ghLink).get();

            //page title
            String title = doc.title();
            System.out.println("Title : " + title);

            //get info from Assignment1
            Elements links = doc.getElementsByClass("markdown-body").select("td");
            int i = 0;
            int j = 0;
            for (Element link : links) {
                if (link.text().length() == 6 && match.isMatch("[0-9]", link.text()) && i < sL.length) {
                    sL[i][0] = link.text();
                    i++;
                } else if (match.isMatch("[a-zA-Z]", link.text()) && j < sL.length) {
                    sL[j][1] = link.text();
                    j++;
                }
            }
            System.out.println("Total Student: " + i);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
