package com.reactivedashboard.server.websocket;

import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class TemperatureHandler implements WebSocketHandler {

    private Flux<String> temperatureStream = Flux.interval(Duration.ofMillis(1000L))
            .map(num -> num % 100)
            .map(num -> Long.toString(num));

    @Override
    public Mono<Void> handle(WebSocketSession webSocketSession) {

        return webSocketSession
                .send(temperatureStream
                .map(webSocketSession::textMessage));
    }
}