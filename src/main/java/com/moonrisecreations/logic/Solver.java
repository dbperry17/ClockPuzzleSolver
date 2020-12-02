package com.moonrisecreations.logic;

import com.moonrisecreations.pojos.Clock;
import com.moonrisecreations.pojos.Node;

//https://www.baeldung.com/java-depth-first-search
public class Solver
{
    Clock clock;

    public Solver(Clock clock)
    {
        this.clock = clock;
    }

    public void dfs(int start) {
        boolean[] isVisited = new boolean[clock.getAdjNodes().size()];
        System.out.println("\nSolution: ");
        dfsRecursive(start, isVisited);
    }

    private void dfsRecursive(int current, boolean[] isVisited) {
        isVisited[current] = true;
        visit(clock.getNodeList().get(current));
        for (int dest : clock.getAdjNodes().get(current)) {
            if (!isVisited[dest])
                dfsRecursive(dest, isVisited);
        }
    }

    private void visit(Node node)
    {
        System.out.println("(P: " + node.getPosFrom12() + ", V: " + node.getValue() + ") ");
    }
}
