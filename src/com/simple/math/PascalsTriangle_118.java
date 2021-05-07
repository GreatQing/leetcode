package com.simple.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/5/7 22:30
 *
 * 118. 杨辉三角
 **/
public class PascalsTriangle_118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j ==i) {
                    list.add(1);
                } else {
                    list.add(lists.get(i - 1).get(j - 1) + lists.get(i - 1).get(j));
                }
            }

            lists.add(list);
        }

        return lists;
    }

}
