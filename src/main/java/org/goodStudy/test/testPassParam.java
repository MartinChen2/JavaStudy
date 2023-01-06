package org.goodStudy.test;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

/**
 * @Author dingws
 * @PackageName JavaStudy
 * @Package org.goodStudy.test
 * @Date 2023/1/5 16:35
 * @Version 1.0
 */
public class testPassParam {

    @Data
    static class MyClass {
        private Integer aa = 00;
    }

    static void changIntegerValue(Integer param){
        param = 1;
    }

    static void changStringValue(String param){
        param = new String("xyz");
    }

    static void changClassValue(MyClass param){
        param.setAa(11);
    }

    static void changMapValue(HashMap param){
        param.put("0", "xyz");
    }

    static void changArrayValue(char[] param){
        param[0] = 'x';
        param[1] = 'y';
        param[2] = 'z';
    }

    static void changCharValue(char param) {
        param = 'x';
    }

    public static void main(String[] args) {
        Integer a = new Integer(0);
        System.out.println("a = " + a);
        changIntegerValue(a);
        System.out.println("after chang value --- a = " + a);

        Integer aa = 0;
        System.out.println("aa = " + aa);
        changIntegerValue(aa);
        System.out.println("after chang value --- aa = " + aa);

        String b = "abc";
        System.out.println("b = " + b);
        changStringValue(b);
        System.out.println("after chang value --- b = " + b);

        String c = new String("abc");
        System.out.println("c = " + c);
        changStringValue(c);
//        c = new String("---");
        System.out.println("after chang value --- c = " + c);

        HashMap d = new HashMap();
        d.put("0", "abc");
        System.out.println("d = " + d);
        changMapValue(d);
        System.out.println("after chang value --- d = " + d);

        char[] e = new char[]{'a', 'b', 'c'};
        System.out.println("e = " + e[0] + e[1] + e[2]);
        changArrayValue(e);
        System.out.println("after chang value --- e = " + e[0] + e[1] + e[2]);

        char f = 'a';
        System.out.println("f = " + f);
        changCharValue(f);
        System.out.println("after chang value --- f = " + f);

        MyClass myClass = new MyClass();
        System.out.println("myClass = " + myClass);
        changClassValue(myClass);
        System.out.println("after chang value --- myClass = " + myClass);
    }
}
