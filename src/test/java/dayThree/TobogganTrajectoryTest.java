package dayThree;

import dayTwo.PasswordPhilosophy;
import input.InputReader;
import org.junit.jupiter.api.Test;

import javax.imageio.IIOException;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TobogganTrajectoryTest {

    private TobogganTrajectory tobogganTrajectory = new TobogganTrajectory(new InputReader());
    private String testInput = "TobogganTrajectoryTest.txt";
    private String actualInput = "TobogganTrajectoryActual.txt";

    @Test
    void partOneTest() throws IOException {
        long result =  tobogganTrajectory.partOne(testInput);
        assertEquals(7, result);
    }

    @Test
    void partOneActual() throws IOException {
        long result =  tobogganTrajectory.partOne(actualInput);
        assertEquals(234, result);
    }

    @Test
    void partTwoTest() throws IOException {
        long result =  tobogganTrajectory.partTwo(testInput);
        assertEquals(336, result);
    }

    @Test
    void partTwo() throws IOException {
        long result =  tobogganTrajectory.partTwo(actualInput);
        // had to start using long here, otherwise the answer was incorrect and also too big for integer
        assertEquals(5813773056L, result);
    }
}