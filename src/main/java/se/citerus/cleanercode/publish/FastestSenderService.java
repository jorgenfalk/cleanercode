package se.citerus.cleanercode.publish;

import se.citerus.cleanercode.model.Customer;

/**
 *
 */
public class FastestSenderService implements SenderService {
    public void send(String message, Customer customer) {
        System.out.println("Sending message " + message + " to customer " + customer.name());
    }
}
