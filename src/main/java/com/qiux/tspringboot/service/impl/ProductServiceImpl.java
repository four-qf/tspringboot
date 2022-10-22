package com.qiux.tspringboot.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qiux.tspringboot.entity.Product;
import com.qiux.tspringboot.entity.User;
import com.qiux.tspringboot.mapper.ProductMapper;
import com.qiux.tspringboot.service.ProductService;
import com.qiux.tspringboot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author qiux
 * @Date 2022/4/25
 * @since
 */
@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private UserService userService;

    @Override
    public Product create(Product product) {

        int row = productMapper.insert(product);
        return row > 0 ? product : null;

    }

    public Product query(Long id) {
        Product product = productMapper.selectByPrimaryKey(id);
        return product;
    }

    @Override
    public List<Product> queryAll() {
        List<Product> products = productMapper.queryAll();
        return products;
    }

    @Override
    public List<Product> queryPage(Integer pageNo, Integer pageSize) {
        Page<Product> page = PageHelper.startPage(pageNo, pageSize);
        List<Product> products = productMapper.queryAll();
        log.info("queryPage --------- page:{}", page);
        return products;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    //------------TransactionType.BASE柔性事务需要使用seata+nacos配合使用 TODO
    @ShardingTransactionType(TransactionType.XA)
    public Boolean update(Product product) throws Exception {
        int rows = productMapper.updateByPrimaryKeySelective(product);
        if (rows >0) {
            User user = userService.create(new User("qx_" + product.getId(), "123456", "17608242765"));
            return user != null;
//            int i = 2/0;
        }
        return false;
    }


}
