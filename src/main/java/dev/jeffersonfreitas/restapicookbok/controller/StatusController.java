package dev.jeffersonfreitas.restapicookbok.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/status")
public class StatusController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String getStatus(){
        return "Application is running...";
    }
}
