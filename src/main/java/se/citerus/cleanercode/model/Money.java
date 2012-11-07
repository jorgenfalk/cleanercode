package se.citerus.cleanercode.model;

/**
 *
 */
public class Money {
    private final double value;

    public Money(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public boolean over(double amount) {
        return value > amount;
    }
}
