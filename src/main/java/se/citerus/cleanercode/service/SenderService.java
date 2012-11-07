package se.citerus.cleanercode.service;

import se.citerus.cleanercode.model.Customer;

/**
 *
 */
public interface SenderService {
    void send(String message, Customer c);
}
