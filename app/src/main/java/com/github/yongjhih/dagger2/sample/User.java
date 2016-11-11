package com.github.yongjhih.dagger2.sample;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

@JsonObject
public class User {
    @JsonField
    public String login;
    @JsonField
    public int contributions;

    @JsonField
    public long id;
    @JsonField
    public String avatar_url;
    @JsonField
    public String gravatar_id;
    @JsonField
    public String url;
    @JsonField
    public String html_url;
    @JsonField
    public String followers_url;
    @JsonField
    public String following_url;
    @JsonField
    public String gists_url;
    @JsonField
    public String starred_url;
    @JsonField
    public String subscriptions_url;
    @JsonField
    public String organizations_url;
    @JsonField
    public String repos_url;
    @JsonField
    public String events_url;
    @JsonField
    public String received_events_url;
    @JsonField
    public String type;
    @JsonField
    public boolean site_admin;

    public User() {
    }

    public User(String login, int contributions) {
        this.login = login;
        this.contributions = contributions;
    }
}
