package andrzejkarwoski.services;

import andrzejkarwoski.repository.UsersRepository;
import io.quarkus.vertx.ConsumeEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class AnalyticsService {

    @Inject
    UsersRepository usersRepository;

    @ConsumeEvent(value = "users-request", blocking = true)
    public void consume(String login) {
        usersRepository.updateRequestCount(login);
    }

}
