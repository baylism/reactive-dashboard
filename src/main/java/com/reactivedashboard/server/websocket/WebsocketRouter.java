package com.reactivedashboard.server.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class WebsocketRouter {
    @Bean
    public HandlerMapping handlerMapping() {

        // create a standard map of string to websockethandler
        Map<String, WebSocketHandler> map = new HashMap<>();
        map.put("/websocket/continuous", new ContinuousHandler());
        map.put("/websocket/singletext", new SingleTextHandler());
        map.put("/websocket/echo", new EchoHandler());
        map.put("/websocket/temps", new TemperatureHandler());

        // add our map to a url mapping
        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        mapping.setOrder(10);
        mapping.setUrlMap(map);

        // return the url mapping
        return mapping;
    }

    @Bean
    public WebSocketHandlerAdapter handlerAdapter() {
        return new WebSocketHandlerAdapter();
    }
}
