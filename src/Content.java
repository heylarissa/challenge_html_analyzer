package src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Content {
    public String webpage;
    public Tree genericTree;

    public Content(String webpage) {
        this.webpage = webpage;
        this.genericTree = new Tree("");

    }

    public void getContentPage() throws Exception {
        String content = new String();


        try {
            URL url = new URL(this.webpage);
            BufferedReader readr = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;
            Integer i = 0;
            Node parent = this.genericTree.getRoot();
            
            while ((line = readr.readLine()) != null) {
                if (line != "" ) {
                    content = line.trim().replaceAll("\\s+", " "); // remove espaços em branco
                    
                    if (i == 0) {
                        parent.key = content;
                        this.genericTree.getPile().pushNode(parent);
                    } else {
                        this.genericTree.populateTree(content);
                    }
                }
                i++;
            }
            this.genericTree.showTree( this.genericTree.getRoot() );

            readr.close();

        } catch (MalformedHTML e) {
            System.out.println("malformed HTML");
 
        } catch (Exception e) {
            System.out.println("URL connection error");
        }
    }


}
