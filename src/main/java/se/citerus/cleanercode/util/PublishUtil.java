package se.citerus.cleanercode.util;

import org.apache.commons.collections15.Closure;
import se.citerus.cleanercode.model.Customer;
import se.citerus.cleanercode.repo.SenderRepository;

/**
 *
 */
public class PublishUtil {
    public static Closure<Customer> publishTo(final SenderRepository repository, final String message) {
        return new Closure<Customer>() {
            public void execute(Customer customer) {
                repository.findFastestSenderService().send(message, customer);
            }
        };
    }
}
