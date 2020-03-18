package com.qiux.tspringboot.ctrl.webfluxtest.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;
import org.springframework.web.servlet.HandlerMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qiuxian
 * @date 2020/3/16
 * 注册handler
 */
//@Configuration
public class WebSocketConfiguration {

//    @Autowired
//    @Bean
    public HandlerMapping webSocketMapping(final EchoWebSocketHandler echoWebSocketHandler ) {
        final Map<String, WebSocketHandler> map = new HashMap<>(1);
        map.put("/echo", echoWebSocketHandler);

        final SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        mapping.setOrder(Ordered.HIGHEST_PRECEDENCE);
        mapping.setUrlMap(map);
        return (HandlerMapping) mapping;
    }

//    @Bean
    public WebSocketHandlerAdapter handlerAdapter() {
        return new WebSocketHandlerAdapter();
    }
}
