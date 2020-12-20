package dayOne;

import input.InputReader;

import java.util.List;

public class ReportRepair {

    private final InputReader inputReader;

    public ReportRepair(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    public Integer partOne(String filename) {

        List<Integer> integerList = inputReader.getIntegerList(filename);

        for(int j : integerList) {
            for(int k : integerList) {
                    if (j + k == 2020) {
                        return j * k;
                    }
            }
        }

        return 0;

    }

    public Integer partTwo(String filename) {

        List<Integer> integerList = inputReader.getIntegerList(filename);

        for(int j : integerList) {
            for(int k : integerList) {
                for(int l : integerList) {
                    if (j + k + l == 2020) {
                        return j * k * l;
                    }
                }
            }
        }

        return 0;

    }

}
