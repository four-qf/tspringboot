package com.qiux.tspringboot.effective_java.hashcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qiux
 * @Date 2022/7/30
 * @since
 */
public class PhoneNumber {

    private final short areaCode;

    private final short prefix;

    private final short lineNumber;

    public PhoneNumber(int areaCode, int prefix, int lineNumber) {
        rangeCheck(areaCode, 999, "area Code");
        rangeCheck(prefix, 999, "prefix");
        rangeCheck(lineNumber, 9999, "line number");
        this.areaCode = (short) areaCode;
        this.prefix = (short) prefix;
        this.lineNumber = (short) lineNumber;
    }

    /**
     * 范围校验
     *
     * @param arg
     * @param max
     * @param name
     */
    private static void rangeCheck(int arg, int max, String name) {
        if (arg < 0 || arg > max) {
            throw new IllegalArgumentException(name + ":" + arg);
        }
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == this) return true;
        if (!(obj instanceof PhoneNumber)) return false;
        PhoneNumber pn = (PhoneNumber) obj;
        return pn.lineNumber == lineNumber
                && pn.prefix == prefix
                && pn.areaCode == areaCode;

    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * lineNumber + result;
        result = 31 * prefix + result;
        result = 31 * areaCode + result;
        return result;
    }

     public static void main(String[] args) {
        PhoneNumber phoneNumber = new PhoneNumber(707, 867, 5309);
        PhoneNumber phoneNumber2 = new PhoneNumber(707, 867, 5309);
        System.out.println(phoneNumber.equals(phoneNumber2));
        Map<PhoneNumber, String> m = new HashMap<>();
        m.put(phoneNumber, "Jenny");
        System.out.println(m.get(phoneNumber2));
    }

}
