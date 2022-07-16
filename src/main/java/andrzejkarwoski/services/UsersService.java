package andrzejkarwoski.services;

import andrzejkarwoski.clients.GithubClient;
import andrzejkarwoski.model.UserMetadata;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import java.util.Optional;

@ApplicationScoped
public class UsersService {

    @Inject
    @RestClient
    GithubClient githubClient;

    public UserMetadata getUserMetadata(String login){
        Optional<UserMetadata> optionalUserMetadata = githubClient.getUserMetadata(login);
        if (optionalUserMetadata.isEmpty()) {
            throw new NotFoundException();
        }
        return optionalUserMetadata.get();
    }


}
