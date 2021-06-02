package AlgoExc03;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


public class ConsolenTest {
    Console console = new Console();

    @Test
    public void guTestReadIntegerFromStdIn1() {
        System.setIn(new ByteArrayInputStream("0".getBytes()));
        int test = console.readIntegerFromStdIn("Please insert a number: ");
        assertEquals(0,test);
    }

    @Test
    public void gutTestReadIntegerFromStdIn2() {
        System.setIn(new ByteArrayInputStream("-5".getBytes()));
        int test = console.readIntegerFromStdIn("Please insert a number: ");
        assertEquals(-5,test);
    }
    @Test
    public void randTestReadIntegerFromStdIn2() {
        // Integer.MAX_VALUE
        System.setIn(new ByteArrayInputStream("2147483647".getBytes()));
        int test = console.readIntegerFromStdIn("Please insert a number: ");
        assertEquals(2147483647,test);

    }
    @Test
    public void randTestReadIntegerFromStdIn3() {
        // Integer.MIN_VALUE
        System.setIn(new ByteArrayInputStream("-2147483648".getBytes()));
        int test = console.readIntegerFromStdIn("Please insert a number: ");
        assertEquals(-2147483648,test);
    }

    @Test
    public void schlechtTestReadIntegerFromStdIn1() {
        // invalid input = character
        System.setIn(new ByteArrayInputStream("a".getBytes()));
        assertThrows(NoSuchElementException.class, () ->
            console.readIntegerFromStdIn("Please insert a number: ")
        );
    }
    @Test
    public void schlechtTestReadIntegerFromStdIn2() {
        // invalid input = number bigger than Integer.MAX_VALUE
        System.setIn(new ByteArrayInputStream("2147483649".getBytes()));
        assertThrows(NoSuchElementException.class, () ->
                console.readIntegerFromStdIn("Please insert a number: ")
        );
    }
    @Test
    public void schlechtTestReadIntegerFromStdIn3() {
        // invalid input = number smaller than Integer.MIN_VALUE
        System.setIn(new ByteArrayInputStream("-2147483649".getBytes()));
        assertThrows(NoSuchElementException.class, () ->
                console.readIntegerFromStdIn("Please insert a number: ")
        );
    }

    @Test
    public void gutTestReadStringFromStdIn1() {
        System.setIn(new ByteArrayInputStream("String".getBytes()));
        assertEquals("String",console.readStringFromStdIn("Enter a string: "));
    }

    @Test
    public void gutTestReadStringFromStdIn2() {
        System.setIn(new ByteArrayInputStream("a".getBytes()));
        assertEquals("a",console.readStringFromStdIn("Enter a string: "));
    }
    @Test
    public void gutTestReadStringFromStdIn3() {
        System.setIn(new ByteArrayInputStream("21".getBytes()));
        assertEquals("21",console.readStringFromStdIn("Enter a string: "));
    }


}
