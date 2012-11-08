package se.citerus.cleanercode.model;

/**
 *
 */
public abstract class Entity<T> {
    public abstract Long id();

    public boolean isSame(final Entity<T> entity) {
        return this.id().equals(entity.id());
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object o) {
        return (o != null) && (o.getClass() == this.getClass()) && (isSame((Entity<T>) o));
    }

    @Override
    public int hashCode() {
        return id() != null ? id().hashCode() : 0;
    }
}
