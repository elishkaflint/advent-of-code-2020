package dayThree;

import input.InputReader;
import models.Coordinates;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TobogganTrajectory {

    private final InputReader inputReader;

    public TobogganTrajectory(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    public long partOne(String filename) throws IOException {

        String[][] map = inputReader.getMap(filename);

        return getCount(map, 1, 3);
    }

    public long partTwo(String filename) throws IOException {

        String[][] map = inputReader.getMap(filename);

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
            y = getY(y, ySlope, map[0].length);
            x = getX(x, xSlope);
        }

        System.out.println("xslope ["+xSlope+"] yslope ["+ySlope+"] count ["+count+"]");

        return count;
    }

    private int getY(int y, int slope, int length) {
        int tempPosition = y + slope;
        if(tempPosition > length - 1) {
            return (tempPosition % length);
        } else {
            return tempPosition;
        }
    }

    private int getX(int x, int slope) {
        return x + slope;
    }

}
