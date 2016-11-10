package com.github.yongjhih.dagger2.sample

import com.bluelinelabs.logansquare.annotation.JsonField
import com.bluelinelabs.logansquare.annotation.JsonObject
import com.bluelinelabs.logansquare.annotation.OnJsonParseComplete
import com.bluelinelabs.logansquare.annotation.OnPreJsonSerialize

/**
 *
 * "id": 1296269,
 * "owner": {
 * "login": "octocat",
 * "id": 1,
 * "avatar_url": "https://github.com/images/error/octocat_happy.gif",
 * "gravatar_id": "",
 * "url": "https://api.github.com/users/octocat",
 * "html_url": "https://github.com/octocat",
 * "followers_url": "https://api.github.com/users/octocat/followers",
 * "following_url": "https://api.github.com/users/octocat/following{/other_user}",
 * "gists_url": "https://api.github.com/users/octocat/gists{/gist_id}",
 * "starred_url": "https://api.github.com/users/octocat/starred{/owner}{/repo}",
 * "subscriptions_url": "https://api.github.com/users/octocat/subscriptions",
 * "organizations_url": "https://api.github.com/users/octocat/orgs",
 * "repos_url": "https://api.github.com/users/octocat/repos",
 * "events_url": "https://api.github.com/users/octocat/events{/privacy}",
 * "received_events_url": "https://api.github.com/users/octocat/received_events",
 * "type": "User",
 * "site_admin": false
 * },
 * "name": "Hello-World",
 * "full_name": "octocat/Hello-World",
 * "description": "This your first repo!",
 * "private": false,
 * "fork": true,
 * "url": "https://api.github.com/repos/octocat/Hello-World",
 * "html_url": "https://github.com/octocat/Hello-World",
 * "clone_url": "https://github.com/octocat/Hello-World.git",
 * "git_url": "git://github.com/octocat/Hello-World.git",
 * "ssh_url": "git@github.com:octocat/Hello-World.git",
 * "svn_url": "https://svn.github.com/octocat/Hello-World",
 * "mirror_url": "git://git.example.com/octocat/Hello-World",
 * "homepage": "https://github.com",
 * "language": null,
 * "forks_count": 9,
 * "stargazers_count": 80,
 * "watchers_count": 80,
 * "size": 108,
 * "default_branch": "master",
 * "open_issues_count": 0,
 * "has_issues": true,
 * "has_wiki": true,
 * "has_pages": false,
 * "has_downloads": true,
 * "pushed_at": "2011-01-26T19:06:43Z",
 * "created_at": "2011-01-26T19:01:12Z",
 * "updated_at": "2011-01-26T19:14:43Z",
 * "permissions": {
 * "admin": false,
 * "push": false,
 * "pull": true
 * }
 *

 * @see "https://developer.github.com/v3/repos/"
 */
@JsonObject
class Repo {
    @JsonField
    var id: Long = 0
        get
    @JsonField
    var owner: User? = null
        get
    @JsonField
    var name: String? = null
        get
    @JsonField
    var full_name: String? = null
        get
    @JsonField
    var description: String? = null
        get

    //@JsonField(name = arrayOf("private")) // error: @JsonField only annotate private field or getter/setter
    //var isPrivate: Boolean? = null
    //    get

    @JsonField
    var fork: Boolean? = null
        get
    @JsonField
    var url: String? = null
        get
    @JsonField
    var html_url: String? = null
        get
    @JsonField
    var clone_url: String? = null
        get
    @JsonField
    var git_url: String? = null
        get
    @JsonField
    var ssh_url: String? = null
        get
    @JsonField
    var svn_url: String? = null
        get
    @JsonField
    var mirror_url: String? = null
        get
    @JsonField
    var homepage: String? = null
        get
    @JsonField
    var language: String? = null
        get
    @JsonField
    var forks_count: Int = 0
        get
    @JsonField
    var stargazers_count: Int = 0
        get
    @JsonField
    var watchers_count: Int = 0
        get
    @JsonField
    var size: Int = 0
        get
    @JsonField
    var default_branch: String? = null
        get
    @JsonField
    var open_issues_count: Int = 0
        get
    @JsonField
    var has_issues: Boolean? = null
        get
    @JsonField
    var has_wiki: Boolean? = null
        get
    @JsonField
    var has_pages: Boolean? = null
        get
    @JsonField
    var has_downloads: Boolean? = null
        get
    @JsonField
    var pushed_at: String? = null
        get
    @JsonField
    var created_at: String? = null
        get
    @JsonField
    var updated_at: String? = null
        get
    @JsonField
    var permissions: Permission? = null
        get
}
