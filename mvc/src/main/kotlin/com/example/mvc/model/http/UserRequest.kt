package com.example.mvc.model.http

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategies

import com.fasterxml.jackson.databind.annotation.JsonNaming


@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class UserRequest (
    var name: String?=null,
    var age:Int?=null,
    var email:String?=null,
    var address:String?=null,

    // @JsonProperty("phone_number")// phone_number를 주로 사용한다.
    var phoneNumber:String?=null

)