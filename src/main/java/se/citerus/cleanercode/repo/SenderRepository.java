package se.citerus.cleanercode.repo;

import se.citerus.cleanercode.service.FastestSenderService;
import se.citerus.cleanercode.service.SenderService;

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
