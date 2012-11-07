package se.citerus.cleanercode.repo;

import se.citerus.cleanercode.service.SenderService;

/**
 *
 */
public interface SenderRepository {
    SenderService findFastestSenderService();
}
