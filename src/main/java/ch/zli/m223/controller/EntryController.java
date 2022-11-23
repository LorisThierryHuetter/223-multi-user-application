package ch.zli.m223.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.application_user.ApplicationUser;
import ch.zli.m223.service.EntryService;

@Path("/entries")
@Tag(name = "Entries", description = "Handling of entries")
public class EntryController {

    @Inject
    EntryService entryService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "Index all Entries.", 
        description = "Returns a list of all entries."
    )
    public List<ApplicationUser> index() {
        return entryService.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "Creates a new applicationuser.", 
        description = "Creates a new applicationuser and returns the newly added applicationuser."
    )
    public ApplicationUser create(ApplicationUser applicationuser) {
        return entryService.createApplicationUser(applicationuser);
    }

    @DELETE
    @Path("/{entryId}")
    @Operation(
        summary = "Deletes ApplicationUser.", 
        description = "Deletes an applicationuser."
    )
    public void delete (@PathParam("entryId")Long id){
        entryService.deleteApplicationUser(id);
    }

    @PUT
    @Operation(
        summary = "Updates ApplicationUser",
        description = "Updates the ApplicationUser"
    )
    @Path("/{entryId}")
    public ApplicationUser update(@PathParam("entryId")Long id, ApplicationUser applicationuser){
        applicationuser.setId(id);
        return entryService.updateApplicationUser(id, applicationuser); 
    }

}
