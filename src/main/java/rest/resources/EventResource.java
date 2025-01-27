package rest.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import persistence.model.Event;
import service.EventService;

import java.util.List;

@Path("/events")
public class EventResource {

    private final EventService eventService;

    public EventResource(EventService eventService) {
        this.eventService = eventService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Event getEventById(@PathParam("id") String id) {
        return eventService.findById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Event createEvent(Event event) {
        return eventService.save(event);
    }

    @DELETE
    @Path("/{id}")
    public void deleteEvent(@PathParam("id") String id) {
        eventService.deleteById(id);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int updateEvent(@PathParam("id") String id, Event event) {
        return eventService.update(id, event);
    }
}