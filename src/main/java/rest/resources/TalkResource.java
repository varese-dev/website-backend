package rest.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import persistence.model.Talk;
import service.TalkService;

import java.util.List;

@Path("/talks")
public class TalkResource {
    private final TalkService talkService;

    public TalkResource(TalkService talkService) {
        this.talkService = talkService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Talk> getAllTalks() {
        return talkService.getAllTalks();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Talk getTalkById(@PathParam("id") String id) {
        return talkService.findById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Talk createTalk(Talk talk) {
        return talkService.save(talk);
    }

    @DELETE
    @Path("/{id}")
    public void deleteTalk(@PathParam("id") String id) {
        talkService.deleteById(id);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int updateTalk(@PathParam("id") String id, Talk talk) {
        return talkService.update(id, talk);
    }
}