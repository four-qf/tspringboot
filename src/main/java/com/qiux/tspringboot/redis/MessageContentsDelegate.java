package com.qiux.tspringboot.redis;

/**
 * @author qiux
 * @Date 2022/3/12
 * @since
 */
public interface MessageContentsDelegate {

    void handleMessage(String text);

    void handleMessage(byte[] bytes);

}
