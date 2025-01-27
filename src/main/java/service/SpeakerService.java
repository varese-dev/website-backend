package service;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import persistence.model.Speaker;

import java.util.List;

@ApplicationScoped
public class SpeakerService implements PanacheRepository<Speaker> {
    public List<Speaker> getAllSpeakers() {
        return listAll();
    }

    public Speaker findById(String id) {
        return find("id", id).firstResult();
    }

    @Transactional
    public Speaker save(Speaker speaker) {
        persist(speaker);
        return speaker;
    }

    @Transactional
    public void deleteById(String id) {
        delete("id", id);
    }

    @Transactional
    public int update(String id, Speaker speaker) {
        return update("name = ?1, surname = ?2, biography = ?3 where id = ?4", speaker.getName(), speaker.getSurname(), speaker.getBiography(), id);
    }
}
