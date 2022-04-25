package com.qiux.tspringboot.service;

import com.qiux.tspringboot.entity.Product;

import java.util.List;

/**
 * @author qiux
 * @Date 2022/4/25
 * @since
 */
public interface ProductService {

    Product create(Product product);

    Product query(Long id);

    List<Product> queryAll();

    List<Product> queryPage(Integer pageNo, Integer pageSize);

}
