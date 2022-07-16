package andrzejkarwoski.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "USERS_REQUEST_COUNTS")
public class UsersRequestCount {
    @Id
    private String login;
    private Long requestCount;

    public UsersRequestCount(String login) {
        this.login = login;
        this.requestCount = 1L;
    }

    public UsersRequestCount() {

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Long getRequestCount() {
        return requestCount;
    }

    public void setRequestCount(Long requestCount) {
        this.requestCount = requestCount;
    }
}
