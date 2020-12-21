package day03;

import java.util.Arrays;
import java.util.List;

import static utils.Utils.getLines;

public class TobogganTrajectory {

    private final String[][] map;

    public TobogganTrajectory(String filename) {
        this.map = getMap(getLines(filename));
    }

    public String[][] getMap(List<String> lines) {
        String[][] map = new String[lines.size()][lines.get(0).split("").length];
        for(int i = 0; i < map.length; i++ ) {
            map[i] = lines.get(i).split("");
        }
        return map;
    }

    public long partOne() {
        return getCount(map, 1, 3);
    }

    public long partTwo() {
        List<Coordinates> coordinates = Arrays.asList(
                new Coordinates(1,1),
                new Coordinates(1,3),
                new Coordinates(1,5),
                new Coordinates(1,7),
                new Coordinates(2,1)
        );
        return coordinates.stream().map(coordinate -> getCount(map, coordinate.getX(), coordinate.getY())).reduce(1L, (a, b) -> a * b);
    }

    private long getCount(String[][] map, int xSlope, int ySlope) {

        int count = 0;
        int x = 0;
        int y = 0;

        while(x < map.length) {
            if(map[x][y].equals("#")) {
                count++;
            }
            x = getX(x, xSlope);
            y = getY(y, ySlope, map[0].length);
        }

        return count;
    }

    private int getX(int x, int slope) {
        return x + slope;
    }

    private int getY(int y, int slope, int length) {
        int tempPosition = y + slope;
        if(tempPosition > length - 1) {
            return (tempPosition % length);
        } else {
            return tempPosition;
        }
    }

}
