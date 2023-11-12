package com.example.mvc.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController // REST API Controller 동작
@RequestMapping("/api") // http://localhost:8080/api
class GetApiController {

    @GetMapping("/hello") // GET만 동작 http://localhost:8080/api/hello
    // @GetMapping(path = ["/hello","/abcd" ]) 배열로 만들면 여러 개의 주소를 할당 가능
    fun hello(): String{
        return "hello Kotlin"
    }

    @RequestMapping(method = [RequestMethod.GET]  , path =["/request-mapping"])
    // 제한 없이 get, post, put, delete 다 동작 가능
    // 따라서 method 와 path로 제약을 가할 수 있음
    fun requestMapping(): String {
        return "request-mapping"
    }

    @GetMapping("/get-mapping/path-variable/{name}/{age}") // GET http://localhost:8080/api/get-mapping/path-variable/seoin
    fun pathVariable(@PathVariable name : String, @PathVariable age : Int) : String {
        println("${name} , ${age}")
        return name+" "+age
    }
    @GetMapping("/get-mapping/path-variable2/{name}/{age}") // GET http://localhost:8080/api/get-mapping/path-variable/seoin
    fun pathVariable2(@PathVariable(value = "name") _name : String, @PathVariable(name ="age") age : Int) : String {
        val name = "Kotlin"
        println("${_name} , ${age}")
        return _name+" "+age
    }
}