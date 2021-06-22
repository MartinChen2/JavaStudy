package org.goodStudy.Util;

import java.io.InputStream;

public class LoadResourceUtil {
    void load(){
        InputStream inputStream = LoadResourceUtil.class.getResourceAsStream("test.txt");
        System.out.println("inputStream = " +  inputStream);
        System.out.println("inputStream = " +  inputStream);
    }

    public static void main(String[] args) {
        LoadResourceUtil loadResourceUtil = new LoadResourceUtil();
        loadResourceUtil.load();
    }
}
