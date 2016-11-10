package com.github.yongjhih.dagger2.sample

import com.bluelinelabs.logansquare.annotation.JsonField
import com.bluelinelabs.logansquare.annotation.JsonObject

@JsonObject
class User {
    @JsonField
    var login: String? = null
        get
    @JsonField
    var contributions: Int = 0
        get

    @JsonField
    var id: Long = 0
        get
    @JsonField
    var avatar_url: String? = null
        get
    @JsonField
    var gravatar_id: String? = null
        get
    @JsonField
    var url: String? = null
        get
    @JsonField
    var html_url: String? = null
        get
    @JsonField
    var followers_url: String? = null
        get
    @JsonField
    var following_url: String? = null
        get
    @JsonField
    var gists_url: String? = null
        get
    @JsonField
    var starred_url: String? = null
        get
    @JsonField
    var subscriptions_url: String? = null
        get
    @JsonField
    var organizations_url: String? = null
        get
    @JsonField
    var repos_url: String? = null
        get
    @JsonField
    var events_url: String? = null
        get
    @JsonField
    var received_events_url: String? = null
        get
    @JsonField
    var type: String? = null
        get
    @JsonField
    var site_admin: Boolean = false
        get

    constructor() {
    }

    constructor(login: String, contributions: Int) {
        this.login = login
        this.contributions = contributions
    }
}
