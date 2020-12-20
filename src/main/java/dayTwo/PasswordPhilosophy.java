package dayTwo;

import input.InputReader;
import models.Password;

import java.util.List;

public class PasswordPhilosophy {

    private final InputReader inputReader;

    public PasswordPhilosophy(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    public Integer partOne(String filename) {

        List<Password> passwords = inputReader.getPasswordList(filename);

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

    public Integer partTwo(String filename) {

        List<Password> passwords = inputReader.getPasswordList(filename);

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
