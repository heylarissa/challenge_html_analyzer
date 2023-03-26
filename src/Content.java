package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Content {
    public String webpage;

    public Content(String webpage) {
        this.webpage = webpage;
    }

    public List<String> getContentPage() throws IOException {
        List<String> content = new ArrayList<>();
          
        Tree genericTree = new Tree("treeroot");

        genericTree.insertNode("teste", genericTree.getRoot().key,  genericTree.getRoot());
        genericTree.insertNode("webpage", genericTree.getRoot().key, genericTree.getRoot());
        genericTree.insertNode("tree", genericTree.getRoot().firstSon.key, genericTree.getRoot().firstSon);
        genericTree.insertNode("tree", genericTree.getRoot().firstSon.key, genericTree.getRoot().firstSon);
        genericTree.insertNode("tree", genericTree.getRoot().firstSon.key, genericTree.getRoot().firstSon);
        genericTree.showTree(genericTree.getRoot());
        try {
            URL url = new URL(this.webpage);
            BufferedReader readr = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;
            while ((line = readr.readLine()) != null) {
                if (line != "" ) {
                    content.add(line.trim().replaceAll("\\s+", " ")); // remove espaços em branco
                    System.out.println(content);
                }
            }

            readr.close();
        } catch (MalformedURLException e) {
            System.out.println("Malformed URL Exception raised");
        }
        return content;
    }
}
