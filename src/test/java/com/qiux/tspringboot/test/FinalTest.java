package com.qiux.tspringboot.test;

import com.qiux.tspringboot.test.annontationtest.City;

/**
 * @author qiuxian
 * @date 2020/3/19
 */
public class FinalTest {

    //final基本类型变量赋值后不可被修改
    private static final int i = 0;
    //final引用类型变量 引用地址不可修改 初始化值：1.声明；2.构造器；3.static块
    private static final City city = new City() ;

    //final修饰类 类不能被继承
    final class FinalCityTest {
        public String s = "test";

        public void showCity(){
            System.out.println("成都");
        }
    }

    class Person {

        protected City city = new City();

        //final方法不可被重写
        public final City getCity() {
            city.setCityName("杭州");
            return city;
        }

        public void getUserName(String username){
            System.out.println(username);
        }

    }

    class Student extends Person {

        @Override
        public void getUserName(String username) {
            super.getUserName(username);
        }
    }

    public static void main(String[] args) {
        city.setCityCode(10001);
        city.setCityName("北京");
        System.out.println(city);
        System.out.println("i=" + i);
    }

}
