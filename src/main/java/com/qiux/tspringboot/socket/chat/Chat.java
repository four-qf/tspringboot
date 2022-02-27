package com.qiux.tspringboot.socket.chat;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author qiux
 * @Date 2022/2/27
 * @since
 */
@AllArgsConstructor
@Data
public class Chat {
    private int localPort;
    private int remotePort;
    private String remoteHost;
}
