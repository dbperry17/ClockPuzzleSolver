import myObjects.Clock;

public class Main
{
    public static void main(String[] args)
    {
        Clock clock = new Clock();
        System.out.println(clock.toString());
//        System.out.println("Backwards: ");
//        System.out.println(clock.backwardsString());

//        System.out.println("Checking link from head to tail: " + clock.getHead().getPrevNode().getValue());
//        System.out.println("Checking link from tail to head: " + clock.getTail().getNextNode().getValue());
    }
}
