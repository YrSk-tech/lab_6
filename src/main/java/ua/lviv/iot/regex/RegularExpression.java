package ua.lviv.iot.regex;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {
    public List<String> list = new LinkedList<>();

    public static List<String> text(String html) {
        String htmltext = html;
        List<String> list = new LinkedList<>();
        List<List<String>> listPaterns = new LinkedList<>();
        listPaterns.add(new LinkedList<>());
        listPaterns.get(0).add("<strong>");
        listPaterns.get(0).add("</strong>");
        listPaterns.add(new LinkedList<>());
        listPaterns.get(1).add("<span>");
        listPaterns.get(1).add("</span>");
        listPaterns.add(new LinkedList<>());
        listPaterns.get(2).add("<table>");
        listPaterns.get(2).add("</table>");

        for (List<String> var : listPaterns) {

            Pattern paternVar = Pattern.compile(var.get(0) + ".+?" + var.get(1));
            Matcher matcherVar = paternVar.matcher(htmltext);
            while (matcherVar.find()) {
                String varText = htmltext.substring(matcherVar.start(), matcherVar.end());
                String varSubstring = varText.substring(var.get(0).length(), varText.length() - var.get(1).length());

                list.add(varSubstring);

            }
        }
        Collections.sort(list);
        return list;
    }
}
