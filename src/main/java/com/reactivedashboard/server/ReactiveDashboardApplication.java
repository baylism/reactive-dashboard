package com.reactivedashboard.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RouterFunctions.resources;

@SpringBootApplication
public class ReactiveDashboardApplication {


    @Configuration
    public class GlobalRouter {

        @Bean
        RouterFunction<?> routerFunction() {
            RouterFunction router = resources("/", new ClassPathResource("static/index.html"));
            return router;
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(ReactiveDashboardApplication.class, args);
    }
}
