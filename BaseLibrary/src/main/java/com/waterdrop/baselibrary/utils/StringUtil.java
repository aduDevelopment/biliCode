package com.waterDrop.baselibrary.utils;

/**
 * Created by Kelin on 2020/8/4.
 */

public class StringUtil {

    /**
     * 字符串，每4个字符空格一位
     */
    public static String spaceAt4(String str) {

        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i += 4) {
            if (length - i <= 8) {      //防止ArrayIndexOutOfBoundsException
                sb.append(str.substring(i, i + 4)).append(" ");
                sb.append(str.substring(i + 4));
                break;
            }
            sb.append(str.substring(i, i + 4)).append(" ");
        }

        return sb.toString();
    }
}
