package src;

public class Tree {
    /* Árvore N-Ária */
    private Node root;
    public Pile parents;

    public Tree(String key) {
        this.root = this.createNewNode(key);
        this.parents = new Pile();
    }

    public void populateTree (String content) throws Exception {


        if (content.contains("</")) {
        //Node parent = this.parents.getLastElement();
 /*           String subContent = content.substring(2);
            String subParent = parent.key.substring(1);
            if (!subContent.equals(subParent)){
                throw new Exception("HTML inválido");
            }
*/
            this.getPile().popLastTagNode(); // desempilha

            return;
        }
        else if (content.contains("<")){
            this.parents.pushNode(this.createNewNode(content)); // empilha
        }

        this.insertNode(content);
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

    public boolean insertNode(String newKey) {
        Node parent = this.parents.getLastElement();
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

    public void setRoot(Node value){
        this.root = value;
    }

    public Pile getPile(){
        return this.parents;
    }

}
