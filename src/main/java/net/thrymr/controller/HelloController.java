package net.thrymr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/home")
    public String wish(){
        return "HELLO EVERYONE THIS IS MY FIRST GIT PROJECT";
    }

}
