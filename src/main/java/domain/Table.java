package domain;

public class Table {
    private final int number;
    private boolean isPayed;

    public Table(final int number) {
        this.number = number;
        this.isPayed = true;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public int getNumber() {
        return number;
    }

    public boolean getIsPayed() {
        return isPayed;
    }

    public void toggleIsPayed() {
        isPayed = !isPayed;
    }
}
