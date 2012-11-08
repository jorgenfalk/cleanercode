package se.citerus.cleanercode.repo;

import se.citerus.cleanercode.publish.FastestSenderService;
import se.citerus.cleanercode.publish.SenderService;

/**
 *
 */
public class SenderRepository {
    public static SenderRepository instance() {
        return new SenderRepository();
    }

    public SenderService findFastestSenderService() {
        return new FastestSenderService();
    }
}
