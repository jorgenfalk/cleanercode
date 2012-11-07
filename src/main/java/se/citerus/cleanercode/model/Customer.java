package se.citerus.cleanercode.model;

/**
 *
 */
public class Customer {

    private final Long id;
    private final String name;
    private final Money balance;
    private final CustomerType type;

    public Customer(Long id, String name, Money balance, CustomerType type) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.type = type;
    }

    public Long id() {
        return id;
    }

    public String name() {
        return name;
    }

    public Money balance() {
        return balance;
    }

    public CustomerType type() {
        return type;
    }
}
