package cloud.tteams.share.core.domain;

public abstract class AggregateRoot<T> {
    public abstract void update(T aggregate);

}
