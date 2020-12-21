package day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassportProcessingTest {

    private final PassportProcessing testPassportProcessing1 = new PassportProcessing("src/main/resources/day04/test1.txt");
    private final PassportProcessing testPassportProcessing2 = new PassportProcessing("src/main/resources/day04/test2.txt");
    private final PassportProcessing actualPassportProcessing = new PassportProcessing("src/main/resources/day04/actual.txt");

    @Test
    void partOneTest() {
        Integer result =  testPassportProcessing1.partOne();
        assertEquals(2, result.doubleValue());
    }

    @Test
    void partOneActual() {
        Integer result =  actualPassportProcessing.partOne();
        assertEquals(245, result.doubleValue());
    }

    @Test
    void partTwoTest() {
        Integer result =  testPassportProcessing2.partTwo();
        assertEquals(4, result.doubleValue());
    }

    @Test
    void partTwoActual() {
        Integer result =  actualPassportProcessing.partTwo();
        assertEquals(133, result.doubleValue());
    }
}