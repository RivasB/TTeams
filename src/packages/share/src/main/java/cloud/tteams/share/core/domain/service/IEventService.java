package cloud.tteams.share.core.domain.service;

//@Async
public interface IEventService<T> {
    void create(T entity);

    void update(T entity);

    void delete(T entity);
}
