package ua.lviv.iot.regex;

import static junit.framework.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import junit.framework.Test;

import ua.lviv.iot.regex.RegularExpression;

public class RegularExpressionTest {
    public String html = "<html><body><strong>a" + "</strong>BUG<span>constructor</span>"
            + "<table>c</table><span>d</span></body></html>";

    public void test() {
        List<String> actual = new LinkedList<>();
        List<String> expected = new LinkedList<>();

        actual = RegularExpression.text(html);
        //System.out.println(actual);

        expected.add("a");
        expected.add("c");
        expected.add("constructor");
        expected.add("d");
        RegularExpression.text(html);
        assertEquals(expected, actual);
    }

}
