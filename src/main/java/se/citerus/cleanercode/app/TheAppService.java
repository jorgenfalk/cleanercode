package se.citerus.cleanercode.app;

import com.google.inject.Inject;
import se.citerus.cleanercode.model.Customer;
import se.citerus.cleanercode.model.Campaign;
import se.citerus.cleanercode.model.CustomerType;
import se.citerus.cleanercode.model.HalfOfCampaign;
import se.citerus.cleanercode.repo.CustomerRepository;
import se.citerus.cleanercode.repo.SenderRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 */
public class TheAppService implements AppService{
    private final CustomerRepository customerRepository;
    private final SenderRepository senderRepository = SenderRepository.instance();

    @Inject
    public TheAppService(final CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void onTimerEvent() {
        final List<Customer> customers = customerRepository.getNewCustomers();
        final Campaign campaign = new HalfOfCampaign();
        final Set<Long> ids = new HashSet<Long>();

        if (customers == null) {
            throw new IllegalArgumentException("No new customers found");
        } else {
            List<Customer> temp = new ArrayList<Customer>();
            for (Customer c : customers){
                Long id = c.id();
                ids.add(id);
            }
            for (Long id : ids) {
                for (Customer c : customers) {
                    if (c.id().equals(id)){
                        temp.add(c);
                    }
                }
            }
            for (Customer c : temp) {
                if ((c.type() == CustomerType.GOLD
                    || c.type() == CustomerType.VIP)
                    && c.balance().over(1000.00)){
                    senderRepository.findFastestSenderService().send(campaign.message(), c);
                }
            }
        }
    }
}
