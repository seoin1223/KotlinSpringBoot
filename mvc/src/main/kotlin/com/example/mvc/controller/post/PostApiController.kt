package com.example.mvc.controller.post

import com.example.mvc.model.http.UserRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class PostApiController {

    @RequestMapping(method = [RequestMethod.POST], path = ["/request-mapping"])
    fun postMappingOld(): String{
        return "request-mapping POST"
    }

    @PostMapping("/post-mapping")
    fun postMapping(): String {
        return "post-mapping"
    }

    // request body로 데이터 받기
    // object mapper
    // json -> object , object -> json
    @PostMapping("post-mapping/object")
    fun postMappingObject(@RequestBody userRequest: UserRequest): UserRequest {
        // json -> object로 바뀌어서 들어옴
        println(userRequest)
        return userRequest // object -> json으로 바뀌어서 return 됨
    }
}