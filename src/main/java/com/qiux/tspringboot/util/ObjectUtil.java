package com.qiux.tspringboot.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qiux.tspringboot.entity.Column;
import com.qiux.tspringboot.entity.Product;
import com.qiux.tspringboot.entity.ShowInfo;
import io.micrometer.core.instrument.util.JsonUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author qiux
 * @Date 2022/10/22
 * @since
 */
public class ObjectUtil {

    public static void main(String[] args) {
        Product product = new Product();
        product.setId(1L);
        product.setProductName("qx");
        product.setType("2");
        product.setPrice(new BigDecimal(25));
        product.setCreateTime(new Date());

        String s = JSON.toJSONString(product);
        HashMap<String, Object> map = JSON.parseObject(s, HashMap.class);
        System.out.println(map);
        List<ShowInfo> showInfoList = new ArrayList();

        Class<Product> productClass = Product.class;
        Field[] declaredFields = productClass.getDeclaredFields();
        int i = 0;
        for (Field declaredField : declaredFields) {

            declaredField.setAccessible(true);
            String name = declaredField.getName();
            if (name.equalsIgnoreCase("serialVersionUID")) {
                continue;
            }
            Object value = map.get(name);
            ShowInfo showInfo = new ShowInfo();
            showInfo.setField(name);
            showInfo.setFieldValue(String.valueOf(value));
            showInfo.setId(++i);

            Column annotation = declaredField.getDeclaredAnnotation(Column.class);
            if (annotation != null && StringUtils.isNotEmpty(annotation.desc())) {
                showInfo.setFieldDesc(annotation.desc());
            }
            showInfoList.add(showInfo);

        }

        System.out.println(showInfoList);

    }

}


