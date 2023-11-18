package com.example.mvc.controller.put

import com.example.mvc.model.http.Result
import com.example.mvc.model.http.UserRequest
import com.example.mvc.model.http.UserResponse
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class PutApiController {

    @PutMapping("/put-mapping")
    fun putMapping() : String{
        return "put-mapping"
    }


    @RequestMapping(method = [RequestMethod.PUT], path = ["/request-mapping"])
    fun requestMapping() : String{
        return "request-mapping put method"
    }

    @PutMapping(path = ["/put-mapping/object"])
    fun putMappingObject(@RequestBody userRequest: UserRequest): UserRequest {
        return userRequest
    }

    @PutMapping("/put-mapping/ex")
    fun putMappingEx(@RequestBody userRequest: UserRequest) : UserResponse {
            // 0. userResponse
        return UserResponse().apply {

            // 1. result
            this.result = Result().apply {
                this.resultCode = "OK"
                this.resultMessage = "성공"
            }
        }.apply {

            // 2. description
            this.description = "~~~~~~~~~"

        }.apply {

            // 3. user mutalbe list
            val userList = mutableListOf<UserRequest>()

            userList.add(userRequest)

            userList.add(UserRequest().apply {
                this.name = "a"
                this.age = 10
                this.email = "a@google.com"
                this.phoneNumber = "010-1111-aaaa"
                this.address = "a address"
            })

            userList.add(UserRequest().apply {
                this.name = "b"
                this.age = 10
                this.email = "a@google.com"
                this.phoneNumber = "010-1111-bbb"
                this.address = "b address"
            })

            this.user = userList
        }
    }
}