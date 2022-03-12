package com.qiux.tspringboot.entity.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author qiux
 * @Date 2022/3/12
 * @since
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginUser implements Serializable {
    private static final long serialVersionUID = 319048976828526252L;

    private Integer id;

    private String  username;

}
