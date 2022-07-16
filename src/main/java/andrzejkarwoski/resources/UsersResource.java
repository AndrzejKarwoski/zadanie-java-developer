package andrzejkarwoski.resources;

import andrzejkarwoski.model.UserMetadata;
import andrzejkarwoski.services.UsersService;
import io.vertx.core.eventbus.EventBus;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/users/")
public class UsersResource {

    @Inject
    UsersService usersService;
    @Inject
    EventBus bus;

    @GET()
    @Path("/{login}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserMetadata getUserMetadata(@PathParam("login") String login) {
        bus.send("users-request", login);
        return usersService.getUserMetadata(login);
    }
}