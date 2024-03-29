package com.qiux.tspringboot.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;
import java.util.Date;

/**
 * @author qiuxian
 * @date 2020/7/24
 */
@NoArgsConstructor
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 404733442753945595L;
    private Integer id;

    private String username;

    private String password;

    private String phone;

    private String email;

    private String status;

    private Date createTime;

    private Date updateTime;

    private String operator;

    public User(String username, String password, String phone) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.status = "1";
    }
}
