package dayTwo;

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
