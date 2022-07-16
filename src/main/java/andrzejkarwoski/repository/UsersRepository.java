package andrzejkarwoski.repository;

import andrzejkarwoski.entity.UsersRequestCount;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.transaction.Transactional;

@ApplicationScoped
public class UsersRepository {

    private final String UPDATE_REQUEST_COUNT_SQL = "UPDATE USERS_REQUEST_COUNTS SET requestCount = requestCount + 1 WHERE login = :login ";

    @Inject
    EntityManager entityManager;

    @Transactional
    public void updateRequestCount(String login){
        UsersRequestCount count = entityManager.find(UsersRequestCount.class, login, LockModeType.PESSIMISTIC_WRITE);
        if (count == null) {
            UsersRequestCount create = new UsersRequestCount(login);
            entityManager.persist(create);
        } else {
            entityManager.createQuery(UPDATE_REQUEST_COUNT_SQL).setParameter("login", login).executeUpdate();
        }
    }
}
