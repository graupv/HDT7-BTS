

public class Node {
    //  Association comparable con Key, Value
    //  basado en https://www.baeldung.com/java-binary-tree

    private Association<String, String> data;
    private Node left;
    private Node right;


    public Node(Association d, Node left, Node right){
        this.data = d;
        this.left = left;
        this.right = right;
    }

    public Node(){
        this.data = null;
        this.left = null;
        this.right = null;
    }

    public Node(Association d){
        this.data = d;
        this.left = null;
        this.right = null;
    }

    public void setLeft(Node n){
        this.left = n;
    }

    public void setRight(Node n){
        this.right = n;
    }

    public Node getLeft(){
        return this.left;
    }

    public Node getRight(){
        return this.right;
    }

    public void setData(Association d){
        this.data = d;
    }

    public Association<String, String> getData(){
        return this.data;
    }

    public String toString(){
        return this.data.getValue();
    }

}
