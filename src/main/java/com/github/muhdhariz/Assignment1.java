package com.github.muhdhariz;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Assignment1 {
    static String sS[][] = new String[35][2];
    public static void main(String[] args) {
        new Assignment1().Main();

        for (int i = 0; i < sS.length; i++) {
            System.out.println(sS[i][0] + " " + sS[i][1]);
        }
    }

    private void Main() {
        Match match = new Match();

        try {
            String ghLink = "https://github.com/STIW3054-A191/Main-Issues/issues/1";
            Document doc = Jsoup.connect(ghLink).get();

            //page title
            String title = doc.title();
            System.out.println("Title : " + title);

            Elements data = doc.getElementsByClass("js-timeline-item js-timeline-progressive-focus-container").select("p");
            int i = 0;
            int j = 0;
            for (Element datas : data) {
                String[] splitS = datas.text().split(" ");

                for (int k = 0; k < splitS.length; k++) {
                    if (match.isMatch("[0-9]", splitS[k]) && splitS[k].length() <= 13) {
                        String[] splitE;
                        if (splitS[k].length() > 6) {
                            splitE = splitS[k].split(":");
                            for (int q = 0; q < splitE.length; q++) {
                                if (splitE[q].length() == 6 && match.isMatch("[0-9]", splitE[q])) {
                                    sS[i][0] = splitE[1];
                                    i++;
                                }
                            }
                        } else {
                            sS[i][0] = splitS[k];
                            i++;
                        }
                    } else if (match.isMatch("https", splitS[k])) {
                        String[] splitE;
                        if (match.isMatch("Link:", splitS[k])) {
                            splitE = splitS[k].split("ink:");
                            for (int l = 0; l < splitE.length; l++) {
                                if (splitE[l].length() > 1) {
                                    sS[j][1] = splitE[1];
                                    j++;
                                }
                            }
                        } else {
                            sS[j][1] = splitS[k];
                            j++;
                        }
                    }
                }
            }
            System.out.println("Total Matric = " + i);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}