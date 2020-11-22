package myObjects;
//https://www.baeldung.com/java-circular-linked-list
//adjusted to make doubly-linked

public class Node
{
    private int value;
    //private int posFrom12;
    private Node nextNode;
    private Node prevNode;
    private boolean valid = true;

    public Node(int value) {
        this.value = value;
        //this.posFrom12 = pos;
    }

    //<editor-fold desc="Getters">
    public int getValue()
    {
        return value;
    }
    //Might only be used for debugging purposes

//    public int getPosFrom12()
//    {
//        return posFrom12;
//    }
    public Node getPrevNode()
    {
        return prevNode;
    }

    public Node getNextNode()
    {
        return nextNode;
    }

    public boolean isValid()
    {
        return valid;
    }

    //</editor-fold>

    //<editor-fold desc="Setters">
    public void setValue(int value)
    {
        this.value = value;
    }

//    public void setPosFrom12(int newPos)
//    {
//        posFrom12 = newPos;
//    }

    public void setNextNode(Node nextNode)
    {
        this.nextNode = nextNode;
    }

    public void setPrevNode(Node prevNode)
    {
        this.prevNode = prevNode;
    }

    public void setValid(boolean valid)
    {
        this.valid = valid;
    }
    //</editor-fold>
}
