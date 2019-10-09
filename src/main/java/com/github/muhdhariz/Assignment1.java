package com.github.muhdhariz;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Assignment1 {

    public static void main(String[] args) {
        new Assignment1().Main();
    }

    private void Main() {
        Match match = new Match();

        try {
            String ghLink = "https://github.com/STIW3054-A191/Main-Issues/issues/1";
            Document doc = Jsoup.connect(ghLink).get();

            //page title
            String title = doc.title();
            System.out.println("Title : " + title);
            int total = 0;
            //get info from Assignment1
            Elements name = doc.getElementsByClass("js-timeline-item js-timeline-progressive-focus-container").select("p");
            for (Element names : name) {
                String theLink = names.attr("p");
                String myString = "Matric";

                System.out.println(names);
                if (match.isMatch(myString, theLink)) {
                    //System.out.println(theLink);
                    total++;
                }
            }
            System.out.println("Total Account = " + total);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}