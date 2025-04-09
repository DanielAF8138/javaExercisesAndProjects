public class Letter {
    private char letter;
    private int points;

    public Letter(char letter, int points) {
        this.letter = letter;
        this.points = points;
    }

    public char getLetter() {
        return letter;
    }

    public int getPoints() {
        return points;
    }

    public boolean equals(Letter other) {
        return (letter == other.letter && points == other.points);

    }

    public String toString() {
        return String.format("Letter: %c Points: %d", letter, points);
    }
}
