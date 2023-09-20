package ec.gob.registrocivil.identity.shared.domain.service;

import org.springframework.scheduling.annotation.Async;

@Async
public interface IEventService<T> {
    void create(T entity);

    void update(T entity);

    void delete(T entity);
}
