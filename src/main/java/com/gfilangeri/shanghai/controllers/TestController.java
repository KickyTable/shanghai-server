package com.gfilangeri.shanghai.controllers;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class TestController {
    @GetMapping(value = "/test")
    public String index() {
        return "this is from the backend!";
    }
}
