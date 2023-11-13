package com.example.mvc.controller.post

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class PostApiController {

    @RequestMapping(method = [RequestMethod.POST], path = ["/post-mapping/old"])
    fun postMappingOld(): String{
        return "postMapping"
    }

    @PostMapping("/post-mapping")
    fun postMapping(): String {
        return "post-mapping"
    }
}