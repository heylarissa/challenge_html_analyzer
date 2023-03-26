package src;

public class Tree {
    /* Árvore N-Ária */
    private Node root;

    public Tree(String key) {
        this.root = this.createNewNode(key);
    }

    public void populateTree (String content, Node parent) {
        if (content.contains("</")) {
            
            parent = parent.nextSibling;
            return;
        };
        

        this.insertNode(content, parent.key, parent);
        parent = parent.firstSon;
    }

    public Node createNewNode(String key) {
        Node newNode = new Node();

        newNode.key = key;
        newNode.firstSon = null;
        newNode.nextSibling = null;

        return newNode;
    }

    public void showTree(Node root) {
        if (root == null)
            return;
        System.out.print("(" + root.key);
        Node p = root.firstSon;
        while (p != null) {
            showTree(p);
            p = p.nextSibling;
        }
        System.out.print(")");
    }

    public boolean insertNode(String newKey, String keyParent, Node root) {
        Node parent = this.searchNode(keyParent, root);
        
        if (parent == null) {
            return (false);
        }

        Node child = this.createNewNode(newKey);

        Node p = parent.firstSon;
        if (p == null) {
            parent.firstSon = child;
        } else {
            while (p.nextSibling != null) {
                p = p.nextSibling;

            }
            p.nextSibling = child;
        }

        return (true);

    }

    public Node getRoot() {
        return this.root;
    }

    public Node searchNode(String key, Node root) {
        if (root == null)
            return null;
        if (root.key == key)
            return root;

        Node p = root.firstSon;

        while (p != null) {
            Node resp = searchNode(key, p);
            if (resp != null)
                return (resp);
            p = p.nextSibling;
        }
        return null;

    }
}
