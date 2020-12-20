package dayOne;

import input.InputReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReportRepairTest {

    private ReportRepair reportRepair = new ReportRepair(new InputReader());
    private String testInput = "ReportRepairTest.txt";
    private String actualInput = "ReportRepairActual.txt";

    @Test
    void partOneTest() {
        Integer result =  reportRepair.partOne(testInput);
        assertEquals(514579, result.doubleValue());
    }

    @Test
    void partOneActual() {
        Integer result =  reportRepair.partOne(actualInput);
        assertEquals(388075, result.doubleValue());
    }

    @Test
    void partTwoTest() {
        Integer result =  reportRepair.partTwo(testInput);
        assertEquals(241861950, result.doubleValue());
    }

    @Test
    void partTwoActual() {
        Integer result =  reportRepair.partTwo(actualInput);
        assertEquals(293450526, result.doubleValue());
    }
}