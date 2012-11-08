package se.citerus.cleanercode.repo;

import se.citerus.cleanercode.publish.FastestSenderService;
import se.citerus.cleanercode.publish.SenderService;

/**
 *
 */
public class TheSenderRepository implements SenderRepository {

    public SenderService findFastestSenderService() {
        return new FastestSenderService();
    }
}
