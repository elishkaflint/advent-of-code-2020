package day05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static utils.Utils.getLines;

public class BinaryBoarding {

    private List<String> directions;

    public BinaryBoarding(String filename) {
        this.directions = getLines(filename);
    }

    public int partOne() {

        int max = 0;

        for(String direction : directions) {
            int id = getId(direction);
            if(id > max) {
                max = id;
            }
        }

        return max;
    }

    public int partTwo() {

        List<Integer> ids = new ArrayList<>();

        for(String direction : directions) {
            int id = getId(direction);
            ids.add(id);
        }

        Collections.sort(ids);

        for(int i = 0; i < ids.size(); i++) {
            if((ids.get(i + 1) - ids.get(i)) > 1) {
                return ids.get(i) + 1;
            }
        }

        return 0;
    }

    private int getId(String direction) {

        String[] rows = Arrays.copyOfRange(direction.split(""), 0, 7);
        int row = getPosition(rows, 127, "F");

        String[] cols = Arrays.copyOfRange(direction.split(""), 7, 10);
        int col = getPosition(cols, 7, "L");

        return (row * 8) + col;
    }

    private int getPosition(String[] directions, int end, String goLow) {
        int start = 0;
        for (String direction : directions) {
            if (direction.equals(goLow)) {
                end = ((start + end) / 2);
            } else {
                start = ((start + end) / 2) + 1;
            }
        }
        return start;
    }

}
