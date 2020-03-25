package com.qiux.tspringboot.test.reflect.type;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author qiuxian
 * @date 2020/3/25
 */
@Slf4j
public class TypeBeanTest {

    public static void main(String[] args) {

        Map<String, List> typeMap = Maps.newHashMap();
        initTypeMap(typeMap);

        Object[] declaredFields = TypeBean.class.getDeclaredFields();
        convertTypeMap(typeMap,declaredFields);
        Method[] declaredMethods = TypeBean.class.getDeclaredMethods();
        for (Method method : declaredMethods) {
           Type[] genericTypes = method.getGenericParameterTypes();
           for (Type genericType : genericTypes) {
               Type[] actualTypeArgument = ((ParameterizedType)genericType).getActualTypeArguments();
               convertTypeMap(typeMap,actualTypeArgument);
           }

        }

        for(Map.Entry typeEntry : typeMap.entrySet()) {
            log.info("{}:",typeEntry.getKey());
            List fieldList = (List) typeEntry.getValue();
            for (Object declared : fieldList) {
                if (declared instanceof Field) {
                    Field field = ((Field) declared);
                    log.info("变量名：{}", field.getName());
                    Type genericType = field.getGenericType();
                    log.info("变量声明的类型：{}", genericType.getTypeName());
                }
                if (declared instanceof Type) {
                    Type type = (Type) declared;
                    log.info("方法参数的类型：{}", type.getTypeName());
                }


            }
            System.out.println();

        }
//        for (int i = 0; i < declaredFields.length; i++) {
//            Field declaredField = declaredFields[i];
//            convertTypeMap(typeMap, declaredField);
//        }

//        for (int i = 0; i < declaredFields.length; i++) {
//            Method declaredMethod = declaredMethods[i];
//            convertTypeMap(typeMap, declaredMethod);
//        }



    }

    private static void initTypeMap(Map<String, List> typeMap) {
        typeMap.put("ParameterizedType", new ArrayList());
        typeMap.put("TypeVariable", new ArrayList());
        typeMap.put("GenericArrayType", new ArrayList());
        typeMap.put("WildcardType", new ArrayList());
        typeMap.put("Class", new ArrayList());
    }

    private static void  convertTypeMap(Map<String, List> typeMap, Object[] array) {

        for (int i = 0; i < array.length; i++) {
            Object declared = array[i];
            Type genericType = null;
            if (declared instanceof Field) {
//                System.out.println(((Field) declared).getGenericType());
                genericType = ((Field) declared).getGenericType();
            }
            if (declared instanceof Type) {
                genericType = (Type) declared;

            }
            if (genericType == null)
                continue;
            if (genericType instanceof Class) {
//                log.info("变量类型为Class");
                List paramList = typeMap.get("Class");
                paramList.add(declared);
                typeMap.put("Class", paramList);
            } else if (genericType instanceof ParameterizedType) {
                List paramList = typeMap.get("ParameterizedType");
                paramList.add(declared);
                typeMap.put("ParameterizedType", paramList);
//                log.info("变量类型为ParameterizedType");
            } else if (genericType instanceof TypeVariable) {
                List paramList = typeMap.get("TypeVariable");
                paramList.add(declared);
                typeMap.put("TypeVariable", paramList);
            } else if (genericType instanceof GenericArrayType) {
                List paramList = typeMap.get("GenericArrayType");
                paramList.add(declared);
                typeMap.put("GenericArrayType", paramList);
            } else if (genericType instanceof WildcardType) {
                List paramList = typeMap.get("WildcardType");
                paramList.add(declared);
                typeMap.put("WildcardType", paramList);

            }
        }


    }

}
