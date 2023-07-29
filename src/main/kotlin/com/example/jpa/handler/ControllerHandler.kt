package com.example.jpa.handler

import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.servlet.http.HttpServletRequest

//@ControllerAdvice
class ControllerHandler {

    @ExceptionHandler(RuntimeException::class)
    fun runtimeException(request: HttpServletRequest, ex: RuntimeException): ResponseEntity<*>? {
        return ResponseEntity.badRequest()
            .contentType(MediaType.APPLICATION_JSON).body(ex.message)
    }
}