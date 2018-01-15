package com.tamco.junit;

/**
 * Created by TamCO on 15/01/2018.
 */
public class StringUtils {

    public static String upper(String message) {
        return message.toUpperCase();
    }

    public static String lower(String message) {
        return message.toLowerCase();
    }

    public static boolean equals(String str1, String str2) {
        if (str1 == null) return str2 == null;

        return str1.equals(str2);
    }
}
