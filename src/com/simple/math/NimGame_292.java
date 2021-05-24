package com.simple.math;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/5/24 22:04
 *
 * 292. Nim游戏
 **/
public class NimGame_292 {
    // 只要n能被4整除，则必输，否则必赢
    public static boolean canWinNim(int n) {
        return (n % 4) != 0;
    }

    public static void main(String[] args) {
        System.out.println(canWinNim(1));
        System.out.println(canWinNim(2));
        System.out.println(canWinNim(3));
        System.out.println(canWinNim(4));
        System.out.println(canWinNim(5));
        System.out.println(canWinNim(6));
        System.out.println(canWinNim(7));
        System.out.println(canWinNim(8));
        System.out.println(canWinNim(9));
    }
}
