package se.citerus.cleanercode.model;

/**
 *
 */
public class Recipient {
    private final String name;

    public Recipient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @SuppressWarnings("RedundantIfStatement")
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recipient recipient = (Recipient) o;

        if (name != null ? !name.equals(recipient.name) : recipient.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
