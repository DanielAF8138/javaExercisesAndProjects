public class Hand {
    public static final int MAX_SIZE = 8;
    private Letter[] hand;
    private int size;

    public Hand() {
        this.size = MAX_SIZE;
        this.hand = new Letter[MAX_SIZE];
    }

    public Hand(int size) {
        if (size < 0) {
            this.hand = new Letter[0];
        } else if (size > MAX_SIZE) {
            this.hand = new Letter[MAX_SIZE];
        }
    }

    public boolean insert(Letter[] letter, int index) {
        if (index > 0 && index < hand.length && hand[index] == null) {
            return true;
        } else {
            return false;
        }
    }

    public Letter[] remove(int index) {
        if (hand[index] == null) {
            return null;
        } else if (index > 0 && index < hand.length) {
            hand[index] = null;
        }
    }

    public String toString() {
        String end = "";
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] == null) {
                end += String.format("%d: -", i);
            } else {
                end += String.format("%d: %c", i, hand[i]);
            }
        }
        return end;
    }

    public int indexOf(char letter) {
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] == letter) {
                return i;
            }
        }
        return -1;
    }

    public int getSize() {
        return size;
    }

    public Letter[] getLetter(int index) {
        return index;
    }
}