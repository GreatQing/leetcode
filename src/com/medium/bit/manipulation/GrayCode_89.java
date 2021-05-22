package com.medium.bit.manipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/5/22 15:10
 * <p>
 * 89. 格雷编码
 **/
public class GrayCode_89 {
    public static List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>() {
            {
                add(0);
            }
        };

        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(head + res.get(j));
            }
            head = head << 1;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(grayCode(0));
        System.out.println(grayCode(1));
        System.out.println(grayCode(2));
        System.out.println(grayCode(3));
        System.out.println(grayCode(4));
    }
}
