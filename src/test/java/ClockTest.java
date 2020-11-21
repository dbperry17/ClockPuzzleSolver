import myObjects.Clock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClockTest
{
    Clock clk = new Clock();

    @Test
    public void givenAClock_WhenAddingElements_ThenListContainsThoseElements()
    {
        System.out.println(clk.toString());
        assertEquals(4, clk.findNodePosByValue(8));
        assertEquals(5, clk.findNodePosByValue(37));
    }

    @Test
    public void givenAClock_WhenLookingForNonExistingElement_ThenReturnsFalse()
    {
        System.out.println(clk.toString());
        assertEquals(-1, clk.findNodePosByValue(11));
    }

    @Test
    public void givenAClock_WhenDeletingElements_ThenListDoesNotContainThoseElements()
    {
        System.out.println(clk.toString());
        int del;

        assertEquals(0, del = clk.findNodePosByValue(13));
        assertTrue(clk.deleteNode(del));
        assertEquals(-1, clk.findNodePosByValue(13));

        System.out.println("Removed 13:");
        System.out.println(clk.toString());

        assertEquals(2, del = clk.findNodePosByValue(1));
        assertTrue(clk.deleteNode(del));
        assertEquals(-1, clk.findNodePosByValue(1));

        System.out.println("Removed 1: ");
        System.out.println(clk.toString());

        assertEquals(5, del = clk.findNodePosByValue(4));
        clk.deleteNode(del);
        assertEquals(-1, clk.findNodePosByValue(4));

        System.out.println("Removed 4: ");
        System.out.println(clk.toString());

        System.out.println("Attempt to remove non-existent node:");

        assertEquals(-1, del = clk.findNodePosByValue(9));
        clk.deleteNode(del);
        assertEquals(-1, clk.findNodePosByValue(9));

        System.out.println("Final Clock: ");
        System.out.println(clk.toString());
    }
}