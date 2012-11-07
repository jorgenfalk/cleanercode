package se.citerus.cleanercode.app;

import com.google.inject.Inject;
import org.apache.commons.lang.Validate;
import se.citerus.cleanercode.model.Campaign;
import se.citerus.cleanercode.model.Customer;
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
    private final SenderRepository senderRepository;

    @Inject
    public TheAppService(final CustomerRepository customerRepository, SenderRepository senderRepository) {
        this.customerRepository = customerRepository;
        this.senderRepository = senderRepository;
    }

    public void onTimerEvent() {
        final List<Customer> customers = customerRepository.getNewCustomers();
        final Campaign campaign = new HalfOfCampaign();

        Validate.notNull(customers, "Error initializing the CustomerRepository");

        for (Customer c : getUniqueCustomers(customers)) {
            if (customersOfGreatValue(c)){
                senderRepository.findFastestSenderService().send(campaign.message(), c);
            }
        }
    }


    private boolean customersOfGreatValue(Customer c) {
        return (c.type() == CustomerType.GOLD
                || c.type() == CustomerType.VIP)
                && c.balance().over(1000.00);
    }

    private List<Customer> getUniqueCustomers(List<Customer> customers) {
        final Set<Long> ids = new HashSet<Long>();
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
        return temp;
    }
}
