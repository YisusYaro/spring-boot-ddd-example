package com.ebitware.ehub.shared;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SharedApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SharedApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

    }

}
