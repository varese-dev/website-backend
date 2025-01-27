package service;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import persistence.model.Event;

import java.time.LocalDate;
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

    @Transactional
    public int update(String id, Event event) {
        return update("title = ?1, description = ?2, date = ?3 where id = ?4", event.getTitle(), event.getDescription(), event.getDate(), id);
    }

    public List<Event> findByDate(String date) {
        LocalDate localDate = LocalDate.parse(date);
        return list("date", localDate);
    }
}

