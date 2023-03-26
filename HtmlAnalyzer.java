import java.io.IOException;
import java.util.List;

import src.*;

public class HtmlAnalyzer {

    public static void main(String[] args) throws IOException {
            Content contentPage = new Content("http://hiring.axreng.com/internship/example1.html");
            List<String> temp = contentPage.getContentPage();
        
    }
}
