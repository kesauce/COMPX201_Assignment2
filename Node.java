/**
 * A class for the node in the binary search tree.
 */
public class Node{

    public Appliance value;
    public Node left;
    public Node right;

    public Node(Appliance value){
        this.value = value;
        this.left = null;
        this.right = null;
    }
    
}