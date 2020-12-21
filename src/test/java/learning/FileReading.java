package learning;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FileReading {

    // https://www.baeldung.com/reading-file-in-java

    @Test
    public void inputStream() {

        // Class.getResource can take a "relative" resource name, which is treated relative to the class's package.
        // Alternatively you can specify an "absolute" resource name by using a leading slash.
        // Classloader resource paths are always deemed to be absolute.
        // So the examples below are equivalent:

        InputStream inputStreamWithClass = this.getClass().getResourceAsStream("/testfile.txt");
        assertNotNull(inputStreamWithClass);

        InputStream inputStreamWithClassLoader = this.getClass().getClassLoader().getResourceAsStream("testfile.txt");
        assertNotNull(inputStreamWithClassLoader);
    }

    @Test
    public void simpleBufferedReaderWithInputStream() throws IOException {

        InputStream is = null;
        StringBuilder sb = new StringBuilder();

        try {
            is = this.getClass().getResourceAsStream("/testfile.txt");
            try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line).append(" ");
                }
            }
        } finally {
            if(is != null) {
                is.close();
            }
        }

        assertEquals("hello world ", sb.toString());
    }

    @Test
    public void simpleBufferedReaderWithFileReader() throws IOException {

        String file = "src/main/resources/testfile.txt";

        BufferedReader reader = new BufferedReader(new FileReader(file));
        // readLine() returns null when end of file is reached
        String currentLine = reader.readLine();
        reader.close();

        assertEquals("hello", currentLine);
    }

    @Test
    public void readingSmallFileUsingFilesNIO() throws IOException{

        Path path = Paths.get("src/main/resources/testfile.txt");
//        Path path = Paths.get(getClass().getClassLoader().getResource("testfile.txt").toURI());

        List<String> read = Files.readAllLines(path);

        assertEquals("hello", read.get(0));
        assertEquals("world", read.get(1));
    }

    @Test
    public void readingLargeFileUsingFilesNIOAndBufferedReader() throws IOException {

        Path path = Paths.get("src/main/resources/testfile.txt");
//        Path path = Paths.get(getClass().getClassLoader().getResource("testfile.txt").toURI());

        BufferedReader reader = Files.newBufferedReader(path);
        String line = reader.readLine();

        assertEquals("hello", line);
    }

    @Test
    public void usingFileLines() throws IOException {

        Path path = Paths.get("src/main/resources/testfile.txt");
//        Path path = Paths.get(getClass().getClassLoader().getResource("testfile.txt").toURI());

        Stream<String> lines = Files.lines(path);
        String data = lines.collect(Collectors.joining(" "));
        lines.close();

        assertEquals("hello world", data);
    }

    @Test
    public void withScanner() {

        List<String> stringList = new ArrayList<>();

        InputStream is = this.getClass().getResourceAsStream("/scannerTestFile.txt");
        Scanner scanner = new Scanner(is);

        StringBuilder sb = new StringBuilder();

        while(scanner.hasNextLine()) {
           String line = scanner.nextLine();
           if(!line.isEmpty()) {
               sb.append(line).append(" ");
           } else {
               stringList.add(sb.toString());
               sb.setLength(0);
           }
        }

        stringList.add(sb.toString());

        for(String string : stringList) {
            System.out.println(string);
        }

    }
}
