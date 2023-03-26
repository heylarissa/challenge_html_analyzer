import java.io.IOException;

import src.*;

public class HtmlAnalyzer {

    public static void main(String[] args) throws IOException {
            Content contentPage = new Content("http://hiring.axreng.com/internship/example1.html");
            String temp = contentPage.getContentPage();
        
    }
}
