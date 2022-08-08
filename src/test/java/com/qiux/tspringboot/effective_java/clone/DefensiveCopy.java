package com.qiux.tspringboot.effective_java.clone;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang.time.DateUtils;

import java.text.ParseException;
import java.util.Date;

/**
 * @author qiux
 * @Date 2022/8/8
 * @since 保护性拷贝：通过创建副本对象来避免对象被共享
 */
@Data
@AllArgsConstructor
class Woman {

    private String name;

    private Date birth;

    public Date getBirth() {
        return new Date(birth.getTime());
    }
}
public class DefensiveCopy {

    public static void main(String[] args) throws ParseException {

        Woman woman = new Woman("ketty", DateUtils.parseDateStrictly("2020-09-18", new String[]{"yyyy-MM-dd"}));
        System.out.println(woman);
        Date birth = woman.getBirth();
        birth.setYear(1999);

        System.out.println(woman);

    }

}
