package com.qiux.tspringboot.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class Product implements Serializable {

    private static final long serialVersionUID = 3395627295963994186L;

    @Column(desc = "id")
    private Long id;

    @Column(desc = "产品名称")
    private String productName;

    @Column(desc = "类型")
    private String type;

    @Column(desc = "价格")
    private BigDecimal price;

    @Column(desc = "创建时间")
    private Date createTime;

    @Column(desc = "更新时间")
    private Date updateTime;

}