package com.moonrisecreations.clockpuzzlesolver.pojos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Clock implements Cloneable
{
    private final ArrayList<Node> nodeList = new ArrayList<>();
    private Map<Integer, List<Integer>> adjNodes = new HashMap<>();
    private Node root;

    /*
     * * * * * * * * * CONSTRUCTORS * * * * * * * *
     */
    public Clock()
    {
        this(3, 3, 2, 1, 3, 1, 1, 1);
        // Solution order, via posFrom12: 1, 6, 5, 4, 7, 0, 3, 2

//        this(13, 7, 24, 1, 8, 37, 46, 4);
//        addNode(13);
//        addNode(7);
//        addNode(24);
//        addNode(1);
//        addNode(8);
//        addNode(37);
//        addNode(46);
    }

    public Clock(ArrayList<Integer> nums)
    {
        if (nums != null)
            resetClock(nums);
        else
            System.out.println("Null List");
    }

    public Clock(Integer... nums)
    {
        this((ArrayList<Integer>) Arrays.asList(nums));
    }

    /*
     * * * * * * * FUNCTIONS * * * * * *
     */
    private void addNode(int value)
    {
        int curIndex = nodeList.size(); // Starts at zero because we do this before adding elements
        Node newNode = new Node(value);
        newNode.setPosFrom12(curIndex);
        nodeList.add(newNode);
        adjNodes.putIfAbsent(newNode.getPosFrom12(), new ArrayList<>());
    }

    private void addEdge(int src, int dest)
    {
        adjNodes.get(src).add(dest);
    }

    private void resetClock(ArrayList<Integer> nums)
    {
        nodeList.clear();
        if (nums.size() != 0)
        {
            for (int num : nums)
                addNode(num);

            root = nodeList.get(0);
            if (createLinks())
            {
                System.out.println("Clock created");
            }
        }
        else
            System.out.println("no elements");
    }

    private boolean createLinks()
    {
        int numNodes = nodeList.size();
        int i = 0;
        Boolean[] success = new Boolean[numNodes];

        try
        {
            for (var node : nodeList)
            {
                int backInt = (i + numNodes - node.getValue()) % numNodes;
                int forInt = (i + node.getValue()) % numNodes;
                node.setBackwardNode(nodeList.get(backInt));
                node.setForwardNode(nodeList.get(forInt));
                addEdge(node.getPosFrom12(), node.getBackwardNode().getPosFrom12());
                addEdge(node.getPosFrom12(), node.getForwardNode().getPosFrom12());
                success[i] = true;
                i++;
            }
        } catch (Exception e)
        {
            System.out.println("Not a clock.");
            success[i] = false;
        }

        /*
         * Formula for forward hand and back hand: Backward: 1 -> 6 1 + 8 - 3 = 6 % 8 =
         * 1 (pos + numNodes - value) % numNodes
         * 
         * 4 -> 1 4 + 8 - 3 = 9 % 8 = 1
         * 
         * forward: 1 -> 4 (1 + 3) % 8 = 4 (pos + value) % numNodes
         * 
         * 7 -> 0 (7 + 1) % 8 = 0
         */

        return !(Arrays.asList(success).contains(false));
    }

    /*
     * * * * * * GETTERS * * * * *
     */
    public ArrayList<Node> getNodeList()
    {
        return nodeList;
    }

    public Node getRoot()
    {
        return root;
    }

    public Map<Integer, List<Integer>> getAdjNodes()
    {
        return adjNodes;
    }

    /*
     * * * * * * * * * * * * * * OTHER STANDARD METHODS * * * * * * * * * * * * *
     */
    public String toString()
    {
        StringBuilder output = new StringBuilder();
        output.append("12 position: ").append(root.getValue()).append("\n");
        output.append("Last position: ").append(nodeList.get(nodeList.size() - 1).getValue()).append("\n");

        output.append(root.getValue());
        for (var node : nodeList)
        {
            if (!node.equals(root))
                output.append(", ").append(node.getValue());
        }

        return output.toString();
    }
}
