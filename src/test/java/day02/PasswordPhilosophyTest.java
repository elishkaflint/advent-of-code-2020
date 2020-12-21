package day02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordPhilosophyTest {

    private PasswordPhilosophy testPasswordPhilosophy = new PasswordPhilosophy("src/main/resources/day02/test.txt");
    private PasswordPhilosophy actualPasswordPhilosophy = new PasswordPhilosophy("src/main/resources/day02/actual.txt");

    @Test
    void partOneTest() {
        long result =  testPasswordPhilosophy.partOne();
        assertEquals(2, result);
    }

    @Test
    void partOneActual() {
        long result =  actualPasswordPhilosophy.partOne();
        assertEquals(524, result);
    }

    @Test
    void partTwoTest() {
        long result =  testPasswordPhilosophy.partTwo();
        assertEquals(1, result);
    }

    @Test
    void partTwoActual() {
        long result =  actualPasswordPhilosophy.partTwo();
        assertEquals(485, result);
    }
}