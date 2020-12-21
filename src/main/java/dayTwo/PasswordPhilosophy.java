package dayTwo;

import java.util.List;

import static input.InputReader.getPasswordList;

public class PasswordPhilosophy {

    private final List<Password> passwords;

    public PasswordPhilosophy(String filename) {
        this.passwords = getPasswordList(filename);
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

        int count = 0;

        char charAtMin = password.getEntry().charAt(password.getMin() - 1);
        if(charAtMin == password.getLetter()) { count++; }

        char charAtMax = password.getEntry().charAt(password.getMax() - 1);
        if(charAtMax == password.getLetter()) { count++; }

        return count == 1;
    }

}
