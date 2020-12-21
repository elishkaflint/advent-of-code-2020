package dayThree;

import java.util.Arrays;
import java.util.List;

import static input.InputReader.getMatrix;

public class TobogganTrajectory {

    private final String[][] matrix;

    public TobogganTrajectory(String filename) {
        this.matrix = getMatrix(filename);
    }

    public long partOne() {
        return getCount(matrix, 1, 3);
    }

    public long partTwo() {
        List<Coordinates> coordinates = Arrays.asList(
                new Coordinates(1,1),
                new Coordinates(1,3),
                new Coordinates(1,5),
                new Coordinates(1,7),
                new Coordinates(2,1)
        );
        return coordinates.stream().map(coordinate -> getCount(matrix, coordinate.getX(), coordinate.getY())).reduce(1L, (a, b) -> a * b);
    }

    private long getCount(String[][] matrix, int xSlope, int ySlope) {

        int count = 0;
        int x = 0;
        int y = 0;

        while(x < matrix.length) {
            if(matrix[x][y].equals("#")) {
                count++;
            }
            x = getX(x, xSlope);
            y = getY(y, ySlope, matrix[0].length);
        }

        System.out.println("xslope ["+xSlope+"] yslope ["+ySlope+"] count ["+count+"]");

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
