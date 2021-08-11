package com.qiux.tspringboot.test.createobject;

import org.apache.commons.lang3.StringUtils;

 import java.lang.reflect.Proxy;

/**
 * @author qiuxian
 * @date 2021/8/11
 */
public class InvokeMethod {

    public static void main(String[] args) throws Exception{

        IA ia = (IA) createObject(IA.class.getName() + "$getName=ABC");
        System.out.println(ia.getName());

        ia = (IA) createObject(IA.class.getName() + "$getName=Bcd");
        System.out.println(ia.getName());


    }


    public static Object createObject(String str) throws Exception{


        if (StringUtils.isBlank(str)) {
            return "";
        }

        String substring = str.substring(str.indexOf("$") + 1, str.length());

        if (StringUtils.isBlank(substring)) {
            return "";
        }

        String getName = substring.substring(substring.indexOf("=")+ 1,substring.length());

        return Proxy.newProxyInstance(Class.forName(IA.class.getName()).getClassLoader(), new Class[] {IA.class},
                (proxy, method, args) -> {
                    if ("getName".equals(method.getName()))
                        return getName;
                    throw new Exception();
                }
                );

    }

}
