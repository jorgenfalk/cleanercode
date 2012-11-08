package se.citerus.cleanercode.publish;

import org.apache.commons.collections15.Closure;
import se.citerus.cleanercode.model.Recipient;
import se.citerus.cleanercode.repo.SenderRepository;

/**
 *
 */
public class PublishUtil {
    public static Closure<Recipient> publishTo(final SenderRepository repository, final String message) {
        return new Closure<Recipient>() {
            public void execute(Recipient recipient) {
                repository.findFastestSenderService().send(message, recipient);
            }
        };
    }
}
