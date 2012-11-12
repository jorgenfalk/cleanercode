package se.citerus.cleanercode.app;

import org.junit.Test;
import se.citerus.cleanercode.model.Customer;
import se.citerus.cleanercode.model.CustomerType;
import se.citerus.cleanercode.model.Money;
import se.citerus.cleanercode.repo.CustomerRepository;
import se.citerus.cleanercode.repo.InMemCustomerRepository;

import java.util.Arrays;

/**
 * Test for the app service
 */
public class AppTest {
    @Test
    public void onTimerEvent(){
        AppService service = new TheAppService(createInMemCustomerRepository());
        service.onTimerEvent();
    }

    private CustomerRepository createInMemCustomerRepository(){
        return new InMemCustomerRepository(Arrays.asList(
                new Customer(1L, "Mr X", new Money(987.65), CustomerType.BASIC),
                new Customer(2L, "Ms V", new Money(1234.56), CustomerType.BASIC),
                new Customer(3L, "Ms Y", new Money(2345.67), CustomerType.GOLD),
                new Customer(4L, "Mr Z", new Money(3456.78), CustomerType.VIP)));
    }
}
