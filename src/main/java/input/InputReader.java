package input;

import dayTwo.Password;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputReader {

    public static List<Integer> getIntegerList(String filename) {

        List<Integer> result = new ArrayList<>();

        try {
            Stream<String> lines = Files.lines(Paths.get(filename));
            result = lines.map(Integer::parseInt).collect(Collectors.toList());
            lines.close();
        } catch (IOException e) {
            System.out.println("error when reading "+filename);
        }

        return result;

    }

    public static List<Password> getPasswordList(String filename) {

        List<Password> result = new ArrayList<>();

        try {
            Stream<String> lines = Files.lines(Paths.get(filename));
            result = lines.map(InputReader::getPassword).collect(Collectors.toList());
            lines.close();
        } catch (IOException e) {
            System.out.println("error when reading "+filename);
        }

        return result;

    }

    public static List<String> getStringList(String filename) {

        List<String> result = new ArrayList<>();

        try {
            Stream<String> lines = Files.lines(Paths.get(filename));
            result = lines.collect(Collectors.toList());
            lines.close();
        } catch (IOException e) {
            System.out.println("error when reading "+filename);
        }

        return result;
    }

    public static List<String> getStringListWithEmptyLines(String filename) {

        List<String> stringList = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(filename));
            StringBuilder sb = new StringBuilder();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.isEmpty()) {
                    sb.append(line).append(" ");
                } else {
                    stringList.add(sb.toString());
                    sb.setLength(0);
                }
            }

            stringList.add(sb.toString());
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("error when reading "+filename);
        }

        return stringList;
    }

    public static String[][] getMatrix(String filename) {

        List<String> stringList = getStringList(filename);
        String[] rows = stringList.toArray(new String[0]);

        String[][] matrix = new String[rows.length][];
        int r = 0;
        for(String row : rows) {
            matrix[r++] = row.split("");
        }

        return matrix;
    }

    private static Password getPassword(String string) {

        String[] arr = string.split(" ");

        String[] minMax = arr[0].split("-");
        int min = Integer.parseInt(minMax[0]);
        int max = Integer.parseInt(minMax[1]);

        char letter = arr[1].charAt(0);

        String password = arr[2];

        return new Password(letter, min, max, password);
    }


}
