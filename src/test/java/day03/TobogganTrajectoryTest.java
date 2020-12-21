package day03;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TobogganTrajectoryTest {

    private TobogganTrajectory testTobogganTrajectory = new TobogganTrajectory("src/main/resources/day03/test.txt");
    private TobogganTrajectory actualTobogganTrajectory = new TobogganTrajectory("src/main/resources/day03/actual.txt");

    @Test
    void partOneTest() throws IOException {
        long result =  testTobogganTrajectory.partOne();
        assertEquals(7, result);
    }

    @Test
    void partOneActual() throws IOException {
        long result =  actualTobogganTrajectory.partOne();
        assertEquals(234, result);
    }

    @Test
    void partTwoTest() throws IOException {
        long result =  testTobogganTrajectory.partTwo();
        assertEquals(336, result);
    }

    @Test
    void partTwo() throws IOException {
        long result =  actualTobogganTrajectory.partTwo();
        // had to start using long here, otherwise the answer was incorrect and also too big for integer
        assertEquals(5813773056L, result);
    }
}