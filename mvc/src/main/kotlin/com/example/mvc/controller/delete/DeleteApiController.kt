package com.example.mvc.controller.delete

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class DeleteApiController {

    // Query Param
    @DeleteMapping(path=["/delete-mapping"])
    fun deleteMapping(
            @RequestParam(value = "name") _name : String,
            @RequestParam(name = "age") _age : Int
    ): String {
        println(_name)
        println(_age)
        return _name+" "+_age
    }


    // 1. path variable
    @DeleteMapping("/delete-mapping/name/{name}/age/{age}") // path variable은 대괄호로 묶어준다
    fun deleteMappingPath(
            @PathVariable(value = "name") _name: String,
            @PathVariable(name = "age") _age: Int
    ): String {
        println(_name)
        println(_age)
        println("test2")
        return _name+" "+_age
    }

    // 2. request param

}