package dayOne;

import java.util.List;

import static input.InputReader.getIntegerList;

public class ReportRepair {

    private final List<Integer> integerList;

    public ReportRepair(String filename) {
        this.integerList = getIntegerList(filename);
    }

    public Integer partOne() {

        for(int j : integerList) {
            for(int k : integerList) {
                    if (j + k == 2020) {
                        return j * k;
                    }
            }
        }

        return 0;

    }

    public Integer partTwo() {

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
