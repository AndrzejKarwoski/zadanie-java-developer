package andrzejkarwoski;

import andrzejkarwoski.entity.UsersRequestCount;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.vertx.core.json.JsonObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@QuarkusTestResource(UserResourceMock.class)
public class UsersResourceTest {

    @Inject
    EntityManager entityManager;

    @Test
    public void getUserMetadataNeverRequested() {

        JsonObject response = new JsonObject("""
                {
                  "id": "35598330",
                  "login": "AndrzejKarwoski",
                  "name": null,
                  "type": "User",
                  "calculations": 7.7142857142857135,
                  "avatarUrl": "https://avatars.githubusercontent.com/u/35598330?v=4",
                  "createdAt": "2018-01-19T11:06:57Z"
                }""");

        given()
          .when().get("/users/andrzejkarwoski")
          .then()
             .statusCode(200)
             .body(is(response.encode()));
        UsersRequestCount count = entityManager.getReference(UsersRequestCount.class, "andrzejkarwoski");
        Assertions.assertEquals(1L, count.getRequestCount());
    }

}