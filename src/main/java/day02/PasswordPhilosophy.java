package day02;

import java.util.List;
import java.util.stream.Collectors;

import static utils.Utils.getLines;

public class PasswordPhilosophy {

    private final List<Password> passwords;

    public PasswordPhilosophy(String filename) {
        this.passwords = getLines(filename).stream().map(this::getPassword).collect(Collectors.toList());
    }

    public Integer partOne() {
        int countValidPassword = 0;
        for (Password password : passwords) {
            if(isValid(password)) {
                countValidPassword++;
            }
        }
        return countValidPassword;
    }

    private boolean isValid(Password password) {
        long letterCount = password.getEntry().chars().filter(ch -> ch == password.getLetter()).count();
        return letterCount >= password.getMin() && letterCount <= password.getMax();
    }

    public Integer partTwo() {
        int countValidPassword = 0;
        for (Password password : passwords) {
            if(isValidComplex(password)) {
                countValidPassword++;
            }
        }
        return countValidPassword;
    }

    private boolean isValidComplex(Password password) {
        char charAtMin = password.getEntry().charAt(password.getMin() - 1);
        char charAtMax = password.getEntry().charAt(password.getMax() - 1);
        return charAtMin == password.getLetter() ^ charAtMax == password.getLetter();
    }

    private PasswordPhilosophy.Password getPassword(String string) {
        String[] arr = string.split(" ");
        String[] minMax = arr[0].split("-");
        int min = Integer.parseInt(minMax[0]);
        int max = Integer.parseInt(minMax[1]);
        char letter = arr[1].charAt(0);
        String password = arr[2];
        return new PasswordPhilosophy.Password(letter, min, max, password);
    }

    public class Password {

        private final char letter;
        private final int min;
        private final int max;
        private final String entry;

        public Password(char letter, int min, int max, String entry) {
            this.letter = letter;
            this.min = min;
            this.max = max;
            this.entry = entry;
        }

        public char getLetter() {
            return letter;
        }

        public int getMin() {
            return min;
        }

        public int getMax() {
            return max;
        }

        public String getEntry() {
            return entry;
        }
    }
}
