package se.citerus.cleanercode;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import se.citerus.cleanercode.app.AppService;
import se.citerus.cleanercode.app.TheAppService;
import se.citerus.cleanercode.model.Customer;
import se.citerus.cleanercode.model.CustomerType;
import se.citerus.cleanercode.model.Money;
import se.citerus.cleanercode.repo.CustomerRepository;
import se.citerus.cleanercode.repo.InMemCustomerRepository;

import java.util.Arrays;

/**
 *
 */
public class AppModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(AppService.class).to(TheAppService.class);
    }

    @Provides
    CustomerRepository provideInMemCustomerRepository(){
        return new InMemCustomerRepository(Arrays.asList(
                new Customer(1L, "Mr X", new Money(987.65), CustomerType.BASIC),
                new Customer(2L, "Ms V", new Money(1234.56), CustomerType.BASIC),
                new Customer(3L, "Ms Y", new Money(2345.67), CustomerType.GOLD),
                new Customer(4L, "Mr Z", new Money(3456.78), CustomerType.VIP)));
    }
}
