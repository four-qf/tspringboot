package com.qiux.tspringboot.effective_java.hashcode;

/**
 * @author qiux
 * @Date 2022/7/31
 * @since 协变返回类型:子类覆盖父类方法时的返回类型时，子类返回类型可以是父类返回类型的子类型
 */
class SuperConvariantReturnType {
    public Number demo(float a, float b) {
        Number number = a + b;
        return number;
    }
}

public class ConvariantReturnType extends SuperConvariantReturnType {
    @Override
    public Integer demo(float a, float b) {
        return (int)a + (int)b;
    }

    public static void main(String[] args) {

        SuperConvariantReturnType s = new SuperConvariantReturnType();
        Number number = s.demo(2.2f, 4);
        System.out.println(number);

        ConvariantReturnType c = new ConvariantReturnType();
        Integer num = c.demo(2.2f, 4);
        System.out.println(num);

    }

}


