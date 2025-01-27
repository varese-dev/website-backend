package rest.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import persistence.model.Event;
import persistence.repository.EventRepository;

import java.util.List;

@Path("/events")
public class EventResource {

    private final EventRepository EventRepository;

    public EventResource(persistence.repository.EventRepository eventRepository) {
        EventRepository = eventRepository;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Event> getAllEvents() {
        return EventRepository.getAllEvents();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Event getEventById(@PathParam("id") String id) {
        return EventRepository.findById(id);
    }
}
