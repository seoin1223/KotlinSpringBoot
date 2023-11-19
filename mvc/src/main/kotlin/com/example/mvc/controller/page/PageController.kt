package com.example.mvc.controller.page

import com.example.mvc.model.http.UserRequest
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@Controller // 특정한 html 페이지를 내릴떄 사용하는 어노테이션
class PageController {

    // http:localhost:8080/main
    // html 페이지가 내려짐
    @GetMapping("/main")
    fun main(): String {
        println("init main")
        return "main.html"
    }

    @ResponseBody // String 형태로 내려짐
    @GetMapping("/test")
    fun response(): UserRequest {

        return UserRequest().apply{
            this.name = "seoin"
        }
        //return "main.html"
    }
}