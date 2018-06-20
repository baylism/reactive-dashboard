package com.reactivedashboard.server.websocket;

import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class EchoHandler implements WebSocketHandler{


    @Override
    public Mono<Void> handle(WebSocketSession webSocketSession) {
        String message =  webSocketSession
                .receive()
                .map(WebSocketMessage::getPayloadAsText)
                .toString();

        System.out.println("THIS IS THE STRING" + message);

        return webSocketSession.send(
                Mono.just(webSocketSession.textMessage("my message")));

    }

}
