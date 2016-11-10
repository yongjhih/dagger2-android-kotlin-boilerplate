package com.github.yongjhih.dagger2.sample

import com.bluelinelabs.logansquare.annotation.JsonField
import com.bluelinelabs.logansquare.annotation.JsonObject

/**
 * Created by andrew on 11/11/16.
 */
@JsonObject
class Permission {
    @JsonField
    var admin: Boolean = false
        get
    @JsonField
    var push: Boolean = false
        get
    @JsonField
    var pull: Boolean = false
        get
}
