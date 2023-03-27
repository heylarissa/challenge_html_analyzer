package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Content {
    public String webpage;

    public Content(String webpage) {
        this.webpage = webpage;
    }

    public String getContentPage() throws IOException {
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
                    if (content.contains("</")){
                        genericTree.getPile().popLastTagNode(); // desempilha
                    }
                    else if (!content.contains("/")){
                        
                        genericTree.parents.pushNode(genericTree.createNewNode(content)); // empilha
                    }
                    /*if (i == 0) {
                        parent.key = content;
                    } else {
                        genericTree.populateTree(content, parent);
                    }*/
                }
                i++;
            }
            genericTree.showTree(genericTree.getRoot());

            readr.close();

        } catch (MalformedURLException e) {
            System.out.println("Malformed URL Exception raised");
        }
        return content;
    }
}
