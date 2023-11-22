package com.example.mvc.controller.delete

import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull

@RestController
@RequestMapping("/api")
@Validated
class DeleteApiController {

    // Query Param
    // 1. request param
    @DeleteMapping(path=["/delete-mapping"])
    fun deleteMapping(
            @RequestParam(value = "name") _name : String,

            @NotNull(message = "age값이 누락되었습니다.")
            @Min(value = 20, message = "age는 20보다 커야 합니다.")
            @RequestParam(name = "age") _age : Int
    ): String {
        println(_name)
        println(_age)
        return _name+" "+_age
    }


    // 2. path variable
    @DeleteMapping("/delete-mapping/name/{name}/age/{age}") // path variable은 대괄호로 묶어준다
    fun deleteMappingPath(
            @PathVariable(value = "name") _name: String,
            @PathVariable(name = "age") _age: Int
    ): String {
        println(_name)
        println(_age)
        return _name+" "+_age
    }



}