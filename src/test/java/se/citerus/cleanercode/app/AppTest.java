package se.citerus.cleanercode.app;

import org.junit.Test;
import se.citerus.cleanercode.model.Customer;
import se.citerus.cleanercode.model.CustomerType;
import se.citerus.cleanercode.model.HalfOfCampaign;
import se.citerus.cleanercode.model.Money;
import se.citerus.cleanercode.repo.CustomerRepository;
import se.citerus.cleanercode.repo.InMemCustomerRepository;
import se.citerus.cleanercode.repo.SenderRepository;
import se.citerus.cleanercode.service.SenderService;

import java.util.Arrays;

import static org.mockito.Mockito.*;

/**
 * Test for the app service
 */
public class AppTest {
    @Test
    public void onTimerEvent(){

        SenderRepository senderRepository = mock(SenderRepository.class);
        SenderService senderService = mock(SenderService.class);
        String message = new HalfOfCampaign().message();

        AppService service = new TheAppService(createInMemCustomerRepository(), senderRepository);

        when(senderRepository.findFastestSenderService()).thenReturn(senderService);

        service.onTimerEvent();

        verify(senderService, times(2)).send(eq(message), any(Customer.class));
    }

    private CustomerRepository createInMemCustomerRepository(){
        return new InMemCustomerRepository(Arrays.asList(
                new Customer(1L, "Mr X", new Money(987.65), CustomerType.BASIC),
                new Customer(2L, "Ms V", new Money(1234.56), CustomerType.BASIC),
                new Customer(3L, "Ms Y", new Money(2345.67), CustomerType.GOLD),
                new Customer(4L, "Mr Z", new Money(3456.78), CustomerType.VIP)));
    }
}
