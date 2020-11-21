package myObjects;

import java.util.ArrayList;

public class Clock implements Cloneable
{
    private Node head = null;
    private Node tail = null;
    private final ArrayList<Integer> originalNodeVals = new ArrayList<>();
    private int curNumNodes = 0;
    private Node forHand;
    private Node backHand;

    //<editor-fold desc="Constructors">
    public Clock()
    {
        this(3, 3, 2, 1, 3, 1, 1, 1);
        //Solution order, via posFrom12: 1, 6, 5, 4, 7, 0, 3, 2

//        this(13, 7, 24, 1, 8, 37, 46, 4);
//        addNode(13);
//        addNode(7);
//        addNode(24);
//        addNode(1);
//        addNode(8);
//        addNode(37);
//        addNode(46);
    }

    public Clock(Integer... nums)
    {
        for (int num : nums)
        {
            originalNodeVals.add(num);
            addNode(num);
        }
        forHand = head;
        backHand = head;
    }
    //</editor-fold>

    //<editor-fold desc="Node manipulation">
    public void addNode(int value)
    {
        Node newNode = new Node(value, curNumNodes++);

        if (head == null)
        {
            head = newNode;
            tail = newNode;
            head.setNextNode(tail);
            tail.setPrevNode(head);
        }
        else
        {
            tail.setNextNode(newNode);
            tail.getNextNode().setPrevNode(tail);
        }

        tail = newNode;
        tail.setNextNode(head);
        head.setPrevNode(tail);
    }

    public boolean deleteNode(int posToDelete)
    {
        Node currentNode = head;
        boolean success = false;

        if (posToDelete == -1)
            System.out.println("Cannot delete non-existent node");
        else if (head != null)
        {
            if (currentNode.getPosFrom12() == posToDelete)
            {
                head = head.getNextNode();
                tail.setNextNode(head);
                head.setPrevNode(tail);
                resetPosFrom12();
                success = true;
            }
            else if (tail.getPosFrom12() == posToDelete)
            {
                tail = tail.getPrevNode();
                tail.setNextNode(head);
                head.setPrevNode(tail);
                resetPosFrom12();
                success = true;
            }
            else
            {
                do
                {
                    Node nextNode = currentNode.getNextNode();
                    if (nextNode.getPosFrom12() == posToDelete)
                    {
                        currentNode.setNextNode(nextNode.getNextNode());
                        resetPosFrom12();
                        success = true;
                        break;
                    }
                    currentNode = currentNode.getNextNode();
                }
                while (currentNode != head);
            }
        }

        return success;
    }

    private void resetPosFrom12()
    {
        Node curNode = head;
        int numNodes = 0;
        try
        {
            curNode.setPosFrom12(numNodes++);
            while (curNode.getNextNode() != head)
            {
                curNode = curNode.getNextNode();
                curNode.setPosFrom12(numNodes++);
            }
        }
        catch (NullPointerException e)
        {
            if (head == null)
                System.out.println("Empty Clock");
            else
                System.out.println("Clock repositioning error");
        }
    }

    private void resetClock()
    {
        for(int i = 0; i < curNumNodes; i++)
        {
            deleteNode(i);
        }

        for (Integer originalNodeVal : originalNodeVals)
        {
            addNode(originalNodeVal);
        }
    }
    //</editor-fold>

    //<editor-fold desc="Getters">
    public Node getForHand()
    {
        return forHand;
    }

    public Node getBackHand()
    {
        return backHand;
    }
    //</editor-fold>

    //<editor-fold desc = "Setters">
    public void setForHand(int newPos)
    {
        this.forHand = findNodeByPos(newPos);
    }

    public void setBackHand(int newPos)
    {
        this.backHand = findNodeByPos(newPos);
    }
    //</editor-fold>

    //<editor-fold desc = "Hand Movers">
    public void moveForHand(int move)
    {
        this.forHand = findNodeByPos((forHand.getPosFrom12() + move) % curNumNodes);
    }

    public void moveBackHand(int move)
    {
        this.backHand = findNodeByPos((backHand.getPosFrom12() + curNumNodes - move) % curNumNodes);
    }
    //</editor-fold>

    //<editor-fold desc = "Finders">
    public int findNodePosByValue(int searchValue)
    {
        Node currentNode = head;
        int pos = -1;

        if (head != null)
        {
            do
            {
                if (currentNode.getValue() == searchValue)
                {
                    pos = currentNode.getPosFrom12();
                    break;
                }
                currentNode = currentNode.getNextNode();
            }
            while (currentNode != head);
        }

        return pos;
    }

    public Node findNodeByPos(int posValue)
    {
        Node curNode = head;

        try
        {
            for (int i = 0; i < posValue; i++)
            {
                curNode = curNode.getNextNode();
            }
        }
        catch (NullPointerException e)
        {
            if (head == null)
                System.out.println("Empty Clock");
        }

        return curNode;
    }
    //</editor-fold>

    //<editor-fold desc="Other Standard Methods">
    public boolean equals(Object otherObject)
    {
        boolean equals = false;
        if (otherObject != null)
            if (otherObject.getClass().equals(this.getClass()))
            {
                ArrayList<Integer> thisValues = this.originalNodeVals;
                ArrayList<Integer> otherValues = ((Clock) otherObject).originalNodeVals;
                equals = thisValues.equals(otherValues);
            }

        return equals;
    }

    public String toString()
    {
        StringBuilder output = new StringBuilder();
        StringBuilder pos = new StringBuilder();
        output.append("Head: ").append(head.getValue()).append("\n");
        output.append("Tail: ").append(tail.getValue()).append("\n");


        Node curNode = head;
        try
        {
            output.append(head.getValue());
            pos.append(head.getPosFrom12());
            while (curNode.getNextNode() != head)
            {
                curNode = curNode.getNextNode();
                output.append(", ").append(curNode.getValue());
                pos.append(", ").append(curNode.getPosFrom12());
            }

            output.append("\nPosition from 12: ").append(pos.toString());
        }
        catch (NullPointerException e)
        {
            if (head == null)
                output.append("Empty Clock");
            else
                output.insert(0, "Clock error. Current Order: \n\t");
        }

        return output.toString();
    }
    //</editor-fold>
}
