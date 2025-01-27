package persistence.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import persistence.model.Event;

@ApplicationScoped
public class EventRepository implements PanacheRepository<Event> {
}