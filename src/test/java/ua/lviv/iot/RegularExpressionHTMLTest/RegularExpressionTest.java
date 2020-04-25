package ua.lviv.iot.RegularExpressionHTMLTest;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import ua.lviv.iot.RegularExpressionHTML.RegularExpression;

public class RegularExpressionTest {
    public String html = "<html><body><strong>a"
            + "</strong>BUG<span>constructor</span>"
            + "<table>c</table><span>d</span></body></html>";
    
    @Test
    public void test() {
        List<String> actual = new LinkedList<>();
        List<String> expected = new LinkedList<>();
        
        actual = RegularExpression.text(html);
        
        expected.add("a");
        expected.add("c");
        expected.add("constructor");
        expected.add("d");
        RegularExpression.text(html);
        assertEquals(expected,actual);
        //assertEquals(expected.get(1),actual.get(1));
       // assertEquals(expected.get(2),actual.get(2));
       // assertEquals(expected.get(3),actual.get(3));
    }

}
