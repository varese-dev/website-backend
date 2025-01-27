package persistence.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import persistence.model.Event;

import java.util.List;

@ApplicationScoped
public class EventRepository implements PanacheRepository<Event> {
    public List<Event> getAllEvents() {
        return listAll();
    }

    public Event findById(String id) {
        return find("id", id).firstResult();
    }
}