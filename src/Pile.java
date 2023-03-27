package src;

import java.util.ArrayList;

public class Pile {
    private ArrayList<Node> pile;
    private int positionPile;

    public Pile (){
        this.pile = new ArrayList<>();
        this.positionPile = -1;
    }

    public Node getLastElement(){
        Integer index = this.pile.size() - 1;
        return this.pile.get(index);
    }

    public boolean emptyPile() {
        if (this.positionPile == -1){
            return true;
        }

        return false;
    }

    public int pileSize(){
        
        if (this.emptyPile()){
            return 0;
        }
        return this.positionPile + 1;
    }

    public void pushNode( Node value){
        // empilha
        this.pile.add(value);
        this.positionPile++;

    }

    public ArrayList<Node> popLastTagNode() {
        // desempilha
        if (this.emptyPile()){
            return null;
        }
        
        Integer position = this.positionPile;

        Node s = this.pile.get(position);
        this.pile.remove(s); // remove objeto anterior
        while (!s.key.contains("<")){
            position--;
            s = this.pile.get(position);
        }

        this.pile.remove(s);
        
        this.positionPile= this.positionPile -2;
        return this.pile;
    }

}
