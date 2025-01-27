package rest.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import persistence.model.Partner;
import persistence.model.Speaker;
import service.PartnerService;

import java.util.List;

@Path("/partners")
public class PartnerResource {
    private final PartnerService partnerService;

    public PartnerResource(PartnerService partnerService) {
        this.partnerService = partnerService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Partner> getAllPartners() {
        return partnerService.getAllPartners();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Partner getPartnerById(@PathParam("id") String id) {
        return partnerService.findById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Partner createPartner(Partner partner) {
        return partnerService.save(partner);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int updateSpeaker(@PathParam("id") String id, Partner partner) {
        return partnerService.update(id, partner);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Partner deletePartner(@PathParam("id") String id) {
        return partnerService.deleteById(id);
    }
}
