package input;

import models.Password;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputReader {

    public List<Integer> getIntegerList(String filename) {

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

    public List<Password> getPasswordList(String filename) {

        List<Password> result = new ArrayList<>();

        try {
            Stream<String> lines = Files.lines(Paths.get(filename));
            result = lines.map(this::getPassword).collect(Collectors.toList());
            lines.close();
        } catch (IOException e) {
            System.out.println("error when reading "+filename);
        }

        return result;

    }

    public List<String> getStringList(String filename) throws IOException {

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

    public String[][] getMap(String filename) throws IOException {

        List<String> stringList = getStringList(filename);
        String[] rows = stringList.toArray(new String[0]);

        String[][] matrix = new String[rows.length][];
        int r = 0;
        for(String row : rows) {
            matrix[r++] = row.split("");
        }

        return matrix;



    }

    private Password getPassword(String string) {

        String[] arr = string.split(" ");

        String[] minMax = arr[0].split("-");
        int min = Integer.parseInt(minMax[0]);
        int max = Integer.parseInt(minMax[1]);

        char letter = arr[1].charAt(0);

        String password = arr[2];

        return new Password(letter, min, max, password);

    }

}
