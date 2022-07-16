package andrzejkarwoski.clients;

import andrzejkarwoski.model.UserMetadata;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@RegisterRestClient(configKey = "github")
@Consumes(MediaType.APPLICATION_JSON)
public interface GithubClient {

    @GET
    @Path("/users/{login}")
    Optional<UserMetadata> getUserMetadata(@PathParam String login);
}
