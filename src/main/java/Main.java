import logic.Solver;
import myObjects.Clock;

public class Main
{
    public static void main(String[] args)
    {
        Clock clock = new Clock();
        System.out.println(clock.toString());

        Solver solver = new Solver(clock);
        solver.dfs(0);
        solver.dfs(1);
        solver.dfs(2);
        solver.dfs(3);
        solver.dfs(4);
        solver.dfs(5);
        solver.dfs(6);
        solver.dfs(7);
//        System.out.println("Backwards: ");
//        System.out.println(clock.backwardsString());

//        System.out.println("Checking link from head to tail: " + clock.getHead().getPrevNode().getValue());
//        System.out.println("Checking link from tail to head: " + clock.getTail().getNextNode().getValue());
    }
}
