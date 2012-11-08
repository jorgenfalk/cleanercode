package se.citerus.cleanercode.app;

import org.junit.Test;
import se.citerus.cleanercode.model.*;
import se.citerus.cleanercode.publish.SenderService;
import se.citerus.cleanercode.repo.CustomerRepository;
import se.citerus.cleanercode.repo.SenderRepository;

import java.util.Arrays;

import static org.mockito.Mockito.*;

/**
 * Test for the app service
 */
public class AppTest {
    private final CustomerRepository customerRepository = mock(CustomerRepository.class);
    private final SenderService sender = mock(SenderService.class);
    private final SenderRepository senderRepository = mock(SenderRepository.class);

    @Test
    public void publishOffer(){
        Customer customer = new Customer(3L,"Ms Y",new Money(2345.67),CustomerType.GOLD);
        AppService service = new TheAppService(customerRepository, senderRepository);

        when(customerRepository.getNewCustomers()).thenReturn(Arrays.asList(customer));
        when(senderRepository.findFastestSenderService()).thenReturn(sender);

        service.sendHalfOfOfferToCustomersOfGreatValue();

        verify(sender).send(new HalfOfCampaign().message(), new Recipient(customer.name()));
    }

    @Test
    public void shouldNotPublishOffer(){
        Customer customer = new Customer(3L,"Ms Q",new Money(987.13),CustomerType.GOLD);
        AppService service = new TheAppService(customerRepository, senderRepository);

        when(customerRepository.getNewCustomers()).thenReturn(Arrays.asList(customer));
        when(senderRepository.findFastestSenderService()).thenReturn(sender);

        service.sendHalfOfOfferToCustomersOfGreatValue();

        verify(sender, never()).send(anyString(), eq(new Recipient(customer.name())));
    }
}
