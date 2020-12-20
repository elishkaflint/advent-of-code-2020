package dayTwo;

import input.InputReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordPhilosophyTest {

    private PasswordPhilosophy passwordPhilosophy = new PasswordPhilosophy(new InputReader());
    private String testInput = "PasswordPhilosophyTest.txt";
    private String actualInput = "PasswordPhilosophyActual.txt";


    @Test
    void partOneTest() {
        Integer result =  passwordPhilosophy.partOne(testInput);
        assertEquals(2, result.doubleValue());
    }

    @Test
    void partOneActual() {
        Integer result =  passwordPhilosophy.partOne(actualInput);
        assertEquals(524, result.doubleValue());
    }

    @Test
    void partTwoTest() {
        Integer result =  passwordPhilosophy.partTwo(testInput);
        assertEquals(1, result.doubleValue());
    }

    @Test
    void partTwoActual() {
        Integer result =  passwordPhilosophy.partTwo(actualInput);
        assertEquals(485, result.doubleValue());
    }
}