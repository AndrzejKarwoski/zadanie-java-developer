package andrzejkarwoski.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserMetadata {

    private String id;
    private String login;
    private String name;
    private String type;
    private String avatarUrl;
    private String createdAt;
    private Double publicRepos;
    private Double followers;
    private Double calculations;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("avatarUrl")
    public String getAvatarUrl() {
        return avatarUrl;
    }

    @JsonProperty("avatar_url")
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @JsonProperty("createdAt")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonIgnore
    public Double getPublicRepos() {
        return publicRepos;
    }

    @JsonProperty("public_repos")
    public void setPublicRepos(Double publicRepos) {
        this.publicRepos = publicRepos;
    }

    @JsonIgnore
    public Double getFollowers() {
        return followers;
    }

    @JsonProperty("followers")
    public void setFollowers(Double followers) {
        this.followers = followers;
    }

    public Double getCalculations() {
        return (6 / this.followers * (2 + this.publicRepos));
    }
}
