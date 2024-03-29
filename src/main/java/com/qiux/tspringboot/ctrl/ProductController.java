package com.qiux.tspringboot.ctrl;

import com.qiux.tspringboot.entity.Product;
import com.qiux.tspringboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author qiux
 * @Date 2022/4/25
 * @since
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public Product create(Product product) {
        try {
            product = productService.create(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }

    @GetMapping("/query")
    public Product queryById(Long id) {
        Product product = productService.query(id);
        return product;
    }

    @GetMapping("/query-all")
    public List<Product> queryAll() {
        List<Product> products = productService.queryAll();
        return products;
    }

    @GetMapping("/query-page")
    public List<Product> queryPage(Integer pageNo, Integer pageSize) {
        List<Product> products = productService.queryPage(pageNo, pageSize);
        return products;
    }

    @PostMapping("/test-tx")
    public Boolean testTransantion(Product product) {
        try {
            return productService.update(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
