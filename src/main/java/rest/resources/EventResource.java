package rest.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import persistence.model.Event;
import persistence.model.Speaker;
import persistence.model.Talk;
import service.EventService;
import service.SpeakerService;
import service.TalkService;

import java.util.List;

@Path("/events")
public class EventResource {

    private final EventService eventService;
    private final TalkService talkService;
    private final SpeakerService speakerService;

    public EventResource(EventService eventService, TalkService talkService, SpeakerService speakerService) {
        this.eventService = eventService;
        this.talkService = talkService;
        this.speakerService = speakerService;
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

    @GET
    @Path("/{id}/talks")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Talk> getTalksByEventId(@PathParam("id") String eventId) {
        return talkService.getTalksByEventId(eventId);
    }

    @GET
    @Path("/{id}/speakers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Speaker> getSpeakersByEventId(@PathParam("id") String eventId) {
        return speakerService.getSpeakersByEventId(eventId);
    }

    @GET
    @Path("date/{date}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Event> getEventByDate(@PathParam("date") String date) {
        return eventService.findByDate(date);
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