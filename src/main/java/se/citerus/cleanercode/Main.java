package se.citerus.cleanercode;

import com.google.inject.Guice;
import com.google.inject.Injector;
import se.citerus.cleanercode.app.AppService;

/**
 *
 */
public class Main {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new AppModule());
        AppService appService = injector.getInstance(AppService.class);
        appService.onTimerEvent();
    }
}
