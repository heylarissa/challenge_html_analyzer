package src;

public class Tree {
    /* Árvore N-Ária */
    private Node root;
    public Pile parents;

    public Tree(String key) {
        this.root = this.createNewNode(key);
        this.parents = new Pile();
    }

    public void populateTree(String content) throws Exception {

        Node child = this.createNewNode(content);
        if (content.contains("</")) {
            // Node parent = this.parents.getLastElement();
            /*
             * String subContent = content.substring(2);
             * String subParent = parent.key.substring(1);
             * if (!subContent.equals(subParent)){
             * throw new Exception("HTML inválido");
             * }
             */
            this.getPile().popLastTagNode(); // desempilha

            return;
        }
        this.insertNode(child);
        if (content.contains("<")) {
            this.parents.pushNode(child); // empilha
        }

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

    public boolean insertNode(Node child) {
        // Node parent = this.parents.getLastElement();
        if (this.parents.getLastElement() == null) {
            return (false);
        }

        Node p = this.parents.getLastElement().firstSon;
        if (p == null) {
            this.parents.getLastElement().firstSon = child;
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

    public void setRoot(Node value) {
        this.root = value;
    }

    public Pile getPile() {
        return this.parents;
    }

}
