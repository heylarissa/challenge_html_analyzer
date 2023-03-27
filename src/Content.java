package src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.URL;

public class Content {
    public String webpage;

    public Content(String webpage) {
        this.webpage = webpage;
    }

    public void getContentPage() throws Exception {
        String content = new String();

        Tree genericTree = new Tree("");

        try {
            URL url = new URL(this.webpage);
            BufferedReader readr = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;
            Integer i = 0;
            Node parent = genericTree.getRoot();
            
            while ((line = readr.readLine()) != null) {
                if (line != "" ) {
                    content = line.trim().replaceAll("\\s+", " "); // remove espaços em branco
                    
                    if (i == 0) {
                        parent.key = content;
                        genericTree.getPile().pushNode(parent);
                    } else {
                        genericTree.populateTree(content);
                    }
                }
                i++;
            }
            genericTree.showTree(genericTree.getRoot());

            readr.close();

        } catch (Exception e) {
            System.out.println("URL connection error");
        }
    }
}
