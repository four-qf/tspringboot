package com.qiux.tspringboot.util;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shardingsphere.spi.encrypt.ShardingEncryptor;

import java.util.Properties;

/**
 * @author qiux
 * @Date 2022/5/3
 * @since
 */
@Getter
@Setter
public class Sha256ShardingEncryptor implements ShardingEncryptor {

    private Properties properties = new Properties();

    @Override
    public void init() {

    }

    @Override
    public String encrypt(Object plaintext) {
        return DigestUtils.sha256Hex(String.valueOf(plaintext));
    }

    @Override
    public Object decrypt(String ciphertext) {
        return ciphertext;
    }

    @Override
    public String getType() {
        return "Sha256";
    }

}
