package myObjects;

public class Clock implements Cloneable
{
    private Node head = null;
    private Node tail = null;
    private Node forHand;
    private Node backHand;
    private int validNodes;
    private boolean firstMove = true;

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
            addNode(num);
        }
        forHand = head;
        backHand = head;
    }
    //</editor-fold>

    //<editor-fold desc="Node manipulation">
    public void addNode(int value)
    {
        Node newNode = new Node(value);

        if (head == null)
        {
            head = newNode;
            tail = newNode;
            head.setNextNode(tail);
            tail.setPrevNode(head);
            forHand = newNode;
            backHand = newNode;
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

    public boolean deleteNode(Node nodeToDelete)
    {
        boolean success = false;

        if(nodeToDelete != null)
        {
            nodeToDelete.setValid(false);
            validNodes--;
            success = true;
        }
        else
            System.out.println("Node does not exist.");

        return success;
    }

    private void resetClock()
    {
        Node curNode = head;
        validNodes = 0;
        curNode.setValid(true);
        validNodes++;
        while(curNode.getNextNode() != head)
        {
            curNode = curNode.getNextNode();
            curNode.setValid(true);
            validNodes++;
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
        for(int i = 0; i < move; i++)
            forHand = forHand.getNextNode();
    }

    public void moveBackHand(int move)
    {
        for(int i = 0; i < move; i++)
            backHand = backHand.getPrevNode();
    }
    //</editor-fold>

    //<editor-fold desc = "Functions">
    public boolean chooseNode(int position)
    {
        boolean pointedNode = false;
        boolean success = false;
        Node chosenNode = findNodeByPos(position);

        if(!firstMove)
        {
            if(forHand == chosenNode || backHand == chosenNode)
                pointedNode = true;
        }
        else
        {
            firstMove = false;
            pointedNode = true; //Not technically true, but works fine with logic
        }

        if(pointedNode)
        {
            if (chosenNode.isValid())
            {
                success = deleteNode(chosenNode);
                if (validNodes == 0)
                {
                    System.out.println("Puzzle Solved!");
                }
                else
                {
                    forHand = chosenNode;
                    backHand = chosenNode;
                    moveForHand(chosenNode.getValue());
                    moveBackHand(chosenNode.getValue());
                }
            }
            else
            {
                System.out.println("Not a valid node.");

                if (!forHand.isValid() && !backHand.isValid())
                {
                    System.out.println("Game over. Restart.");
                    resetClock();
                }
            }
        }
        else
            System.out.println("Please choose a node being pointed at.");

        return success;
    }

    public Node findNodeByPos(int position)
    {
        Node curNode = head;

        try
        {
            for (int i = 0; i < position; i++)
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
//    public boolean equals(Object otherObject)
//    {
//        boolean equals = false;
//        if (otherObject != null)
//            if (otherObject.getClass().equals(this.getClass()))
//            {
//                ArrayList<Integer> otherValues = ((Clock) otherObject).originalNodeVals;
//                equals = this.originalNodeVals.equals(otherValues);
//            }
//
//        return equals;
//    }

    public String toString()
    {
        StringBuilder output = new StringBuilder();
        //StringBuilder pos = new StringBuilder();
        output.append("Head: ").append(head.getValue()).append("\n");
        output.append("Tail: ").append(tail.getValue()).append("\n");


        Node curNode = head;
        try
        {
            output.append(head.getValue());
            //pos.append(head.getPosFrom12());
            while (curNode.getNextNode() != head)
            {
                curNode = curNode.getNextNode();
                output.append(", ").append(curNode.getValue());
                //pos.append(", ").append(curNode.getPosFrom12());
            }

            //output.append("\nPosition from 12: ").append(pos.toString());
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
