package com.reactivedashboard.server.websocket;

import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class TemperatureStream {

    public Flux<String> durationFlux() {
        return Flux.interval(Duration.ofMillis(1000L))
                .map(num -> num % 100)
                .map(num -> toString());
    }
}
