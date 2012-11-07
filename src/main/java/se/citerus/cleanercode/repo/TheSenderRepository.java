package se.citerus.cleanercode.repo;

import se.citerus.cleanercode.service.FastestSenderService;
import se.citerus.cleanercode.service.SenderService;

/**
 *
 */
public class TheSenderRepository implements SenderRepository {

    public SenderService findFastestSenderService() {
        return new FastestSenderService();
    }
}
