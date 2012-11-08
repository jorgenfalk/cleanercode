package se.citerus.cleanercode.app;

import com.google.inject.Inject;
import org.apache.commons.lang.Validate;
import se.citerus.cleanercode.model.Campaign;
import se.citerus.cleanercode.model.Customer;
import se.citerus.cleanercode.model.HalfOfCampaign;
import se.citerus.cleanercode.repo.CustomerRepository;
import se.citerus.cleanercode.repo.SenderRepository;

import java.util.List;

import static org.apache.commons.collections15.CollectionUtils.*;
import static se.citerus.cleanercode.model.Customer.asRecipient;
import static se.citerus.cleanercode.model.Customer.ofGreatValue;
import static se.citerus.cleanercode.publish.PublishUtil.publishTo;

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

    public void sendHalfOfOfferToCustomersOfGreatValue() {
        final List<Customer> customers = customerRepository.getNewCustomers();
        final Campaign campaign = new HalfOfCampaign();

        Validate.notNull(customers, "Error initializing the CustomerRepository");

        forAllDo(collect(select(customers, ofGreatValue()), asRecipient()),
                publishTo(senderRepository, campaign.message()));
    }
}
