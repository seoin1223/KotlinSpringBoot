package com.example.mvc.model.http

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategies

import com.fasterxml.jackson.databind.annotation.JsonNaming


//@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class UserRequest (
    var name: String?=null,
    var age:Int?=null,
    var email:String?=null,
    var address:String?=null,
    var phoneNumber:String?=null


    /* 네이밍 컨벤션
    @JsonProperty("phone_number")// phone_number를 주로 사용한다. but 개별적으로 사용해야 함으로 여러 개가 있을 경우 변환하는데 번거롭다
    따라서
    @JsonNaming()을 통해 해당 클래스가 어떤 case를 사용할 것인지 명시하면 편하다
    */
)

/* ex
    {
        "result" : {
            "result_code" : "OK",
            "result_message" : "성공"
        },
        "description"   : "~~~~~",
        "user" : [
             {   "name" : "a",
                "age"  : "27",
                "email": " ",
                "phoneNumber" : ""
               },
             {   "name" : "b",
                "age"  : "27",
                "email": " ",
                "phoneNumber" : ""
               },
            {   "name" : "c",
                "age"  : "27",
                "email": " ",
                "phoneNumber" : ""
               }
        ]
    }
*/

