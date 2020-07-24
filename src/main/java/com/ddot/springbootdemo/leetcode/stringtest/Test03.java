package com.ddot.springbootdemo.leetcode.stringtest;

import java.util.ArrayList;
import java.util.List;

/**
 * Z字型变换
 */
public class Test03 {
    public String convert(String s,int numRow){
        if (numRow < 2)return s;

        List<StringBuilder> list = new ArrayList<>();

        for (int i = 0; i < numRow; i++) {
            list.add(new StringBuilder());
        }

        int nowRow = 0,flag = -1;
        for (char c : s.toCharArray()) {
            if (nowRow == 0 || nowRow == numRow - 1) flag = -flag;    // now = 0  row = 3  1 ,3 2,3

            list.get(nowRow).append(c);                               //
            nowRow += flag;                                           // now=1             2    1
        }

        StringBuilder sb = new StringBuilder();
        for (StringBuilder stringBuilder : list) {
            sb.append(stringBuilder);
        }
        return sb.toString();



    }

}
