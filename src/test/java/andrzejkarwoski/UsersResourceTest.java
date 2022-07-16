package andrzejkarwoski;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.vertx.core.json.JsonObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@QuarkusTestResource(UserResourceMock.class)
public class UsersResourceTest {

    @Test
    public void getUserMetadata() {

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


    }

}