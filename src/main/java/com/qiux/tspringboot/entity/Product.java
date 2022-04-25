package com.qiux.tspringboot.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Product implements Serializable {

    private static final long serialVersionUID = 3395627295963994186L;
    private Long id;

    private String productName;

    private String type;

    private Date createTime;

    private Date updateTime;

}