package andrzejkarwoski;

import java.util.Collections;
import java.util.Map;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class UserResourceMock implements QuarkusTestResourceLifecycleManager {

    private WireMockServer wireMockServer;

    @Override
    public Map<String, String> start() {
        wireMockServer = new WireMockServer();
        wireMockServer.start();

        wireMockServer.stubFor(get(urlEqualTo("/users/andrzejkarwoski"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody(
                                """
                                        {
                                            "login": "AndrzejKarwoski",
                                            "id": 35598330,
                                            "node_id": "MDQ6VXNlcjM1NTk4MzMw",
                                            "avatar_url": "https://avatars.githubusercontent.com/u/35598330?v=4",
                                            "gravatar_id": "",
                                            "url": "https://api.github.com/users/AndrzejKarwoski",
                                            "html_url": "https://github.com/AndrzejKarwoski",
                                            "followers_url": "https://api.github.com/users/AndrzejKarwoski/followers",
                                            "following_url": "https://api.github.com/users/AndrzejKarwoski/following{/other_user}",
                                            "gists_url": "https://api.github.com/users/AndrzejKarwoski/gists{/gist_id}",
                                            "starred_url": "https://api.github.com/users/AndrzejKarwoski/starred{/owner}{/repo}",
                                            "subscriptions_url": "https://api.github.com/users/AndrzejKarwoski/subscriptions",
                                            "organizations_url": "https://api.github.com/users/AndrzejKarwoski/orgs",
                                            "repos_url": "https://api.github.com/users/AndrzejKarwoski/repos",
                                            "events_url": "https://api.github.com/users/AndrzejKarwoski/events{/privacy}",
                                            "received_events_url": "https://api.github.com/users/AndrzejKarwoski/received_events",
                                            "type": "User",
                                            "site_admin": false,
                                            "name": null,
                                            "company": null,
                                            "blog": "",
                                            "location": null,
                                            "email": null,
                                            "hireable": null,
                                            "bio": null,
                                            "twitter_username": "IIoo3018",
                                            "public_repos": 7,
                                            "public_gists": 0,
                                            "followers": 7,
                                            "following": 11,
                                            "created_at": "2018-01-19T11:06:57Z",
                                            "updated_at": "2022-07-12T18:28:16Z"
                                        }"""
                        )));

        return Collections.singletonMap("quarkus.rest-client.\"andrzejkarwoski.clients.GithubClient\".url", wireMockServer.baseUrl());
    }

    @Override
    public void stop() {
        if (null != wireMockServer) {
            wireMockServer.stop();
        }
    }
}