package dayFive;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryBoardingTest {

    private BinaryBoarding testBinaryBoarding = new BinaryBoarding("BinaryBoardingTest.txt");
    private BinaryBoarding actualBinaryBoarding = new BinaryBoarding("BinaryBoardingActual.txt");

    @Test
    void partOneTest() {
        Integer result =  testBinaryBoarding.partOne();
        assertEquals(820, result.doubleValue());
    }

    @Test
    void partOneActual() {
        Integer result = actualBinaryBoarding.partOne();
        assertEquals(904, result.doubleValue());
    }

    @Test
    void partTwoActual() {
        Integer result = actualBinaryBoarding.partTwo();
        assertEquals(669, result.doubleValue());
    }
}