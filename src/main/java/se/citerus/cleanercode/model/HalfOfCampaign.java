package se.citerus.cleanercode.model;

/**
 *
 */
public class HalfOfCampaign implements Campaign {
    public String message() {
        return "As our most valuable customer, we would like to give you an offer you just can't resist: " +
                "50% off on everything in our store! Hurry, the offer will expire in 3 days.";
    }
}
