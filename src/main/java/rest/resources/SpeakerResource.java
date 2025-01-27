package rest.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import persistence.model.Speaker;
import service.SpeakerService;

import java.util.List;

@Path("/speakers")
public class SpeakerResource {

    private final SpeakerService speakerService;

    public SpeakerResource(SpeakerService speakerService) {
        this.speakerService = speakerService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Speaker> getAllSpeakers() {
        return speakerService.getAllSpeakers();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Speaker getSpeakerById(@PathParam("id") String id) {
        return speakerService.findById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Speaker createSpeaker(Speaker speaker) {
        return speakerService.save(speaker);
    }

    @DELETE
    @Path("/{id}")
    public void deleteSpeaker(@PathParam("id") String id) {
        speakerService.deleteById(id);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int updateSpeaker(@PathParam("id") String id, Speaker speaker) {
        return speakerService.update(id, speaker);
    }
}
