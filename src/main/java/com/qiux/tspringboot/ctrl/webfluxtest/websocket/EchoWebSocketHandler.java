package com.qiux.tspringboot.ctrl.webfluxtest.websocket;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Mono;

/**
 * @author qiuxian
 * @date 2020/3/16
 */
//@Component
public class EchoWebSocketHandler implements WebSocketHandler {

    @Override
    public Mono<Void> handle(WebSocketSession webSocketSession) {
        return webSocketSession.send(webSocketSession.receive().map(msg ->
            webSocketSession.textMessage(msg.getPayloadAsText())));
    }
}
