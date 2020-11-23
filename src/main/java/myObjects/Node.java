package myObjects;
//https://www.baeldung.com/java-circular-linked-list
//adjusted to make doubly-linked

public class Node
{
    private int value;
    private int posFrom12; //To avoid time loss from constantly searching for index of a node in Clock
    private Node forwardNode;
    private Node backwardNode;
    public Node(int value) {
        this.value = value;
        //this.posFrom12 = pos;
    }

    //<editor-fold desc="Getters">
    public int getValue()
    {
        return value;
    }

    public int getPosFrom12()
    {
        return posFrom12;
    }

    public Node getBackwardNode()
    {
        return backwardNode;
    }

    public Node getForwardNode()
    {
        return forwardNode;
    }

    //</editor-fold>

    //<editor-fold desc="Setters">
    public void setValue(int value)
    {
        this.value = value;
    }

    public void setPosFrom12(int pos)
    {
        this.posFrom12 = pos;
    }

    public void setForwardNode(Node forwardNode)
    {
        this.forwardNode = forwardNode;
    }

    public void setBackwardNode(Node backwardNode)
    {
        this.backwardNode = backwardNode;
    }
    //</editor-fold>
}
