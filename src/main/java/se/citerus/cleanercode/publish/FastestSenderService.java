package se.citerus.cleanercode.publish;

import se.citerus.cleanercode.model.Recipient;

/**
 *
 */
public class FastestSenderService implements SenderService {
    public void send(String message, Recipient customer) {
        System.out.println("Sending message " + message + " to customer " + customer.getName());
    }
}
