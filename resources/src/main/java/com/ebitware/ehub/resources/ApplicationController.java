package com.ebitware.ehub.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {
    @GetMapping("/")
    public String getServerStatus() {
        return "Server is working";
    }
}
