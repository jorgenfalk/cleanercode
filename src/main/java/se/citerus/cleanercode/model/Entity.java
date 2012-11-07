package se.citerus.cleanercode.model;

/**
 *
 */
public abstract class Entity<T> {
    public abstract Long id();

    public boolean isSame(final Entity<T> entity) {
        return this.id().equals(entity.id());
    }
}
