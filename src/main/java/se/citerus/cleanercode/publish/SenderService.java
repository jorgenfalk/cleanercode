package se.citerus.cleanercode.publish;

import se.citerus.cleanercode.model.Recipient;

/**
 *
 */
public interface SenderService {
    void send(String message, Recipient recipient);
}
