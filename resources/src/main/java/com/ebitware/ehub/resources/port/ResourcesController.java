package com.ebitware.ehub.resources.port;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebitware.ehub.shared.domain.EHubLogger;

@RestController
@RequestMapping("/resources")
public class ResourcesController {
    @Autowired
    private EHubLogger eHubLogger;

    @GetMapping
    public String getResources() {
        String message = "Server is working ✨";
        this.eHubLogger.log(message);
        return message;
    }
}
