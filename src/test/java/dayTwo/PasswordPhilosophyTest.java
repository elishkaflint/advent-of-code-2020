package dayTwo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordPhilosophyTest {

    private PasswordPhilosophy testPasswordPhilosophy = new PasswordPhilosophy("PasswordPhilosophyTest.txt");
    private PasswordPhilosophy actualPasswordPhilosophy = new PasswordPhilosophy("PasswordPhilosophyActual.txt");

    @Test
    void partOneTest() {
        Integer result =  testPasswordPhilosophy.partOne();
        assertEquals(2, result.doubleValue());
    }

    @Test
    void partOneActual() {
        Integer result =  actualPasswordPhilosophy.partOne();
        assertEquals(524, result.doubleValue());
    }

    @Test
    void partTwoTest() {
        Integer result =  testPasswordPhilosophy.partTwo();
        assertEquals(1, result.doubleValue());
    }

    @Test
    void partTwoActual() {
        Integer result =  actualPasswordPhilosophy.partTwo();
        assertEquals(485, result.doubleValue());
    }
}