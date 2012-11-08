package se.citerus.cleanercode.repo;

import se.citerus.cleanercode.publish.SenderService;

/**
 *
 */
public interface SenderRepository {
    SenderService findFastestSenderService();
}
