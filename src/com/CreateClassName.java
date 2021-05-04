package com;

import java.util.HashMap;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/2 19:41
 **/
public class CreateClassName {

    public static void main(String[] args) {

        String w = "flatten-binary-tree-to-linked-list";
        String num = "114";

        StringBuilder sb = new StringBuilder(w);
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        for (int i = 1; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '-') {
                sb.setCharAt(i + 1, Character.toUpperCase(sb.charAt(i + 1)));
            }
        }

        String s = new String(sb);
        s = s.replaceAll("-", "");
        System.out.println(s + "_" + num);
    }
}
