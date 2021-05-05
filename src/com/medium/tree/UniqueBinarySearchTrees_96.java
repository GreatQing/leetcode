package com.medium.tree;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/5/5 8:45
 * <p>
 * 96. 不同的二叉搜索树
 **/
public class UniqueBinarySearchTrees_96 {

    public static int numTrees(int n) {
        int[] G = new int[n + 1];

        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }

        return G[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(1));
        System.out.println(numTrees(2));
        System.out.println(numTrees(3));
        System.out.println(numTrees(4));
        System.out.println(numTrees(5));
        System.out.println(numTrees(6));
    }
}
