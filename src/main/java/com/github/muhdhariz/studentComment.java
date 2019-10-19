package com.github.muhdhariz;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class studentComment {
    private static Match match = new Match();
    static String[][] sS = new String[40][3];
    private static int i = 0, j = 0, p = 0;

    public static void main(String[] args) {
        new studentComment().Main();
        for (int i = 0; i < sS.length; i++) {
            if (sS[i][0] == null && sS[i][1] == null) {
                sS[i][0] = " ";
                sS[i][1] = " ";
                sS[i][2] = " ";
            } else if (match.isMatch("^ ", sS[i][1])) {
                sS[i][1] = sS[i][1].replaceAll("^ ", "");
            }
        }
    }

    private void Main() {
        try {
            String ghLink = "https://github.com/STIW3054-A191/Main-Issues/issues/1";
            Document doc = Jsoup.connect(ghLink).get();

            Elements data = doc.getElementsByClass("js-timeline-item js-timeline-progressive-focus-container").select("p");

            for (Element datas : data) {
                String[] splitS = datas.text().split(" ");
                for (String split : splitS) {
                    if (match.isMatch("[0-9]", split) && split.length() <= 13) {
                        String[] splitE;
                        if (split.length() > 6) {
                            splitE = split.split(":");
                            for (String s : splitE) {
                                if (s.length() == 6 && match.isMatch("[0-9]", s)) {
                                    sS[i][0] = splitE[1];
                                    i++;
                                }
                            }
                        } else {
                            sS[i][0] = split;
                            i++;
                        }
                    } else if (match.isMatch("https", split)) {
                        String[] splitE;
                        if (match.isMatch("Link:", split)) {
                            splitE = split.split("ink:");
                            for (String s : splitE) {
                                if (s.length() > 1) {
                                    sS[j][2] = splitE[1];
                                    j++;
                                }
                            }
                        } else {
                            sS[j][2] = split;
                            j++;
                        }
                    }
                }

                String[] splitN = datas.text().split("Name");
                for (String s : splitN) {
                    String[] splitN2 = s.split(":");
                    for (String value : splitN2) {
                        String[] splitN3 = value.split("Link");
                        for (String item : splitN3) {
                            String[] splitN4 = item.split("Matric no");
                            for (String element : splitN4) {
                                String[] splitN5 = element.split("link");
                                for (String name : splitN5) {
                                    if (match.isMatch("[a-zA-Z]", name)
                                            && !match.isMatch("[0-9]", name)
                                            && !match.isMatch("https", name)
                                            && !match.isMatch("//", name)
                                            && !match.isMatch("[Mm]atri[cx]", name)) {
                                        sS[p][1] = name;
                                        p++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}