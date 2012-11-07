package se.citerus.cleanercode.model;

import org.apache.commons.collections15.Predicate;
import org.apache.commons.collections15.functors.AndPredicate;

import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class Customer extends Entity<Customer> {

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

    @Override
    public boolean equals(Object o) {
        return this == o || !(o == null || getClass() != o.getClass()) && isSame((Customer) o);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }



    public static Predicate<Customer> ofGreatValue() {
        return new AndPredicate<Customer>(new Customer.UniqueEntityPredicate<Customer>(), new Customer.CustomersOfGreatValuePredicate());
    }
    public static class UniqueEntityPredicate<T extends Entity<T>> implements Predicate<T> {
        private Set<Long> ids = new HashSet<Long>();

        public boolean evaluate(T t) {
            return ids.add(t.id());
        }
    }

    public static class CustomersOfGreatValuePredicate implements Predicate<Customer>{
        public boolean evaluate(Customer c) {
            return (c.type() == CustomerType.GOLD
                    || c.type() == CustomerType.VIP)
                    && c.balance().over(1000.00);
        }
    }


}
