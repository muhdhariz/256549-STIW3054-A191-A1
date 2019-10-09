package com.github.muhdhariz;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class studentList {
    public static void main(String[] args) {
        new studentList().Main();
    }

    private void Main() {
        Match match = new Match();

        try {
            String ghLink = "https://github.com/STIW3054-A191/Assignments/wiki/List_of_Student";
            Document doc = Jsoup.connect(ghLink).get();

            //page title
            String title = doc.title();
            System.out.println("Title : " + title);

            //get info from Assignment1
            Elements links = doc.select("a[href]");
            int i = 0;
            for (Element link : links) {
                String theLink = link.attr("href");
                String myString = "" + i;

                if (match.isMatch(myString, theLink)) {
                    System.out.println(theLink);
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
