package com.mindorks.framework.KotlinMVVM.KotlinData.KotlinModel.KotlinApi

import com.google.gson.annotations.SerializedName

data class LoginResponse_Kotlin (

    @SerializedName("data")
    var access_token : String ?=null,
    var fb_profile_pic_url :String ?=null,
    var google_profile_pic_url :String ?=null,
    var message :String ?=null,
    var server_profile_pic_url :String ?=null,
    var status_code :String ?=null,
    var email :String ?=null,
    var user_id :Long ?=null,
    var user_name :String ?=null

)