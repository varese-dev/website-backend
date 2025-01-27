package service;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import persistence.model.Event;

import java.util.List;

@ApplicationScoped
public class EventService implements PanacheRepository<Event> {
    public List<Event> getAllEvents() {
        return listAll();
    }

    public Event findById(String id) {
        return find("id", id).firstResult();
    }

    @Transactional
    public Event save(Event event) {
        persist(event);
        return event;
    }

    @Transactional
    public void deleteById(String id) {
        delete("id", id);
    }
}

