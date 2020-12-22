package day02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordPhilosophyRegexTest {

    private PasswordPhilosophyRegex testPasswordPhilosophy = new PasswordPhilosophyRegex("src/main/resources/day02/test.txt");
    private PasswordPhilosophyRegex actualPasswordPhilosophy = new PasswordPhilosophyRegex("src/main/resources/day02/actual.txt");

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