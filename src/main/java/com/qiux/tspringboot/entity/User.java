package com.qiux.tspringboot.entity;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

/**
 * @author qiuxian
 * @date 2020/7/24
 */
@ConfigurationProperties("user")
@Configuration
//@RefreshScope
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 404733442753945595L;
    private String id;

}
