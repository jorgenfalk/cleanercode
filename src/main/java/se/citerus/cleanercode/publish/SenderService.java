package se.citerus.cleanercode.publish;

import se.citerus.cleanercode.model.Customer;

/**
 *
 */
public interface SenderService {
    void send(String message, Customer customer);
}
