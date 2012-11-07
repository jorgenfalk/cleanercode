package se.citerus.cleanercode.model;

import org.apache.commons.collections15.Predicate;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 */
public class CustomerTest {
    @Test
    public void customersOfGreatValue(){
        Predicate<Customer> ofGreatValue = Customer.ofGreatValue();

        Assert.assertTrue(
                "GOLD customer with a good account balance should be selected",
                ofGreatValue.evaluate(new Customer(1L,"",new Money(1001.00),CustomerType.GOLD)));

        Assert.assertTrue(
                "Duplicate customers is not of great value",
                !ofGreatValue.evaluate(new Customer(1L,"",new Money(1001.00), CustomerType.GOLD)));
                // Note: we re-use the stateful ofGreatValue predicate instance

        Assert.assertTrue(
                "GOLD customer who is low on cash should not be selected",
                !ofGreatValue.evaluate(new Customer(2L,"",new Money(999.00),CustomerType.GOLD)));

        Assert.assertTrue(
                "NORMAL customers should not be selected even if they are stinking rich",
                !ofGreatValue.evaluate(new Customer(3L, "", new Money(99999999.00), CustomerType.BASIC)));
    }
}
