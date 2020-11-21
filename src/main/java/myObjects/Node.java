package myObjects;
//https://www.baeldung.com/java-circular-linked-list
//adjusted to make doubly-linked

public class Node
{
    private int value;
    private int posFrom12;
    private Node nextNode;
    private Node prevNode;

    public Node(int value, int pos) {
        this.value = value;
        this.posFrom12 = pos;
    }

    public int getValue()
    {
        return value;
    }

    public void setValue(int value)
    {
        this.value = value;
    }

    //Might only be used for debugging purposes
    public int getPosFrom12()
    {
        return posFrom12;
    }

    public void setPosFrom12(int newPos)
    {
        posFrom12 = newPos;
    }

    public Node getNextNode()
    {
        return nextNode;
    }

    public void setNextNode(Node nextNode)
    {
        this.nextNode = nextNode;
    }

    public Node getPrevNode()
    {
        return prevNode;
    }

    public void setPrevNode(Node prevNode)
    {
        this.prevNode = prevNode;
    }
}
