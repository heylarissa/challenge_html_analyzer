
import src.*;

public class HtmlAnalyzer {

    public static void main(String[] args) throws Exception {
            Content contentPage = new Content(args[0]);
            contentPage.getContentPage();

            if ( contentPage.genericTree.getLevel() != 0 ) {
                System.out.println(contentPage.genericTree.getValue());
            }
        
    }
}
