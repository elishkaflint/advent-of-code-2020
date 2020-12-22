    package day02;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static utils.Utils.getLines;

public class PasswordPhilosophyRegex {

    private Pattern pattern = Pattern.compile("(\\d+)-(\\d+) (\\w): ([a-z]*)");

    private final List<String> lines;

    public PasswordPhilosophyRegex(String filename) {
        this.lines = getLines(filename);
    }

    public int partOne() {

        int matches = 0;

        for(String line : lines) {

            Matcher matcher = pattern.matcher(line);
            if(matcher.find()) {

                int min = Integer.parseInt(matcher.group(1));
                int max = Integer.parseInt(matcher.group(2));
                String req = matcher.group(3);
                String password = matcher.group(4);

                long letterCount = Arrays.stream(password.split("")).filter(letter -> letter.equals(req)).count();
                if(min <= letterCount && letterCount <= max) matches++;
            }
        }
        return matches;
    }

    public int partTwo() {

        int matches = 0;

        for(String line : lines) {

            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {

                int pos1 = Integer.parseInt(matcher.group(1));
                int pos2 = Integer.parseInt(matcher.group(2));
                String req = matcher.group(3);
                String password = matcher.group(4);

                if(password.split("")[pos1 - 1].equals(req) ^ password.split("")[pos2 - 1].equals(req)) {
                    matches++;
                }
            }
        }

        return matches;

    }

}
