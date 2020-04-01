package intv;

import java.util.ArrayList;
import java.util.List;

public class ConvertNumbers {

    String convert(double d) {
        //1.转成string
        //2.字符串长度不是3的倍数，少几位补几个" "
        //3.从头每三位遍历添加到list
        //4.处理小数部分
        //5.拼接list为string并trim
        List<String> list = new ArrayList<>();
        String[] strArr = String.valueOf(d).split("\\.");
        String str1 = strArr[0];
        String str2 = null;
        if (strArr.length > 1) {
            str2 = strArr[1];
        }

        // 补位数
        int n = 3 - str1.length() % 3;
        while (n < 3 && n-- > 0) {
            str1 = " " + str1;
        }

        for (int i = 0; i < str1.length(); i = i + 3) {
            list.add(str1.substring(i, i + 3) + (i + 3 != str1.length() ? "," : ""));
        }


        if (str2 != null) {
            list.add("." + str2);
        }

        return String.join("", list).trim();
    }
}
