package utils;

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

public class Utils {

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

    public static List<String> getLines(String filename) {

        List<String> lines = new ArrayList<>();

        try {
            Stream<String> linesStream = Files.lines(Paths.get(filename));
            lines = linesStream.collect(Collectors.toList());
            linesStream.close();
        } catch (IOException e) {
            System.out.println("error when reading "+filename);
        }

        return lines;
    }

    public static List<String> getGroupedLines(String filename) {

        List<String> groupedLines = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(filename));
            StringBuilder sb = new StringBuilder();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.isEmpty()) {
                    sb.append(line).append(" ");
                } else {
                    groupedLines.add(sb.toString());
                    sb.setLength(0);
                }
            }
            groupedLines.add(sb.toString());

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("error when reading "+filename);
        }

        return groupedLines;
    }

}
