package dayOne;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReportRepairTest {

    private ReportRepair testReportRepair = new ReportRepair("ReportRepairTest.txt");
    private ReportRepair actualReportRepair = new ReportRepair("ReportRepairActual.txt");

    @Test
    void partOneTest() {
        Integer result =  testReportRepair.partOne();
        assertEquals(514579, result.doubleValue());
    }

    @Test
    void partOneActual() {
        Integer result =  actualReportRepair.partOne();
        assertEquals(388075, result.doubleValue());
    }

    @Test
    void partTwoTest() {
        Integer result =  testReportRepair.partTwo();
        assertEquals(241861950, result.doubleValue());
    }

    @Test
    void partTwoActual() {
        Integer result =  actualReportRepair.partTwo();
        assertEquals(293450526, result.doubleValue());
    }
}