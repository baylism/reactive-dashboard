package com.reactivedashboard.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.resources;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@SpringBootApplication
public class ReactiveDashboardApplication {

    // @Component
    // public class CustomWebFilter implements WebFilter {
    //
    // //     @Override
    //     public Mono<Void> filter(final ServerWebExchange exchange, final WebFilterChain chain) {
    //
    //         final ServerHttpRequest req = exchange.getRequest();
    //
    //         return req.getURI().getPath().equals("/")
    //                 ? chain.filter(exchange.mutate().request(req.mutate()
    //                 .path("/index.html")
    //                 .build())
    //                 .build())
    //                 : chain.filter(exchange);
    //     }
    // }

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
