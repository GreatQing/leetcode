package com;

import java.util.HashMap;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/2 19:41
 **/
public class Test {

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();

        map.put(1, "Ten");
        map.put(2, "Bai");
        map.put(3, "Ali");

        System.out.println(map.values());

        System.out.println("Value for key 1:" + map.getOrDefault(1, "Not Found"));
        System.out.println("Value for key 4:" + map.getOrDefault(4, "Not Found"));
    }
}
