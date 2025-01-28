package rest.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import persistence.model.Tag;
import service.TagService;

import java.util.List;

@Path("/tags")
public class TagResource {
    private final TagService tagService;

    public TagResource(TagService tagService) {
        this.tagService = tagService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tag> getAllTags() {
        return tagService.getAllTags();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Tag getTagById(@PathParam("id") String id) {
        return tagService.findById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Tag createTag(Tag tag) {
        return tagService.save(tag);
    }

    @DELETE
    @Path("/{id}")
    public void deleteTag(@PathParam("id") String id) {
        tagService.deleteById(id);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int updateTag(@PathParam("id") String id, Tag tag) {
        return tagService.update(id, tag);
    }
}