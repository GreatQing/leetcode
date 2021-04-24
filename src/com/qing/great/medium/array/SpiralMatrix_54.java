package com.qing.great.medium.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/5 22:21
 *
 * 54. 螺旋矩阵
 * 给你一个 m行n列的矩阵matrix，请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 **/
public class SpiralMatrix_54 {

    // 从外部向内部逐层遍历打印，外面一层打印完，里面一层仍热是一个矩阵
    public static List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();

        // 有多少行
        int m = matrix.length;
        // 有多少列
        int n = matrix[0].length;
        // 统计矩阵从外到内的层数
        // 每一层最多会占据两行或者两列，最少会占据一行或者一列。如果只有一层或者一列，也是一层
        // 如果矩阵非空，层数至少为1
        int count = (Math.min(m, n) + 1) / 2;

        int i = 0;

        // 由外而内遍历，逐层打印
        while (i < count) {
            // 从左到右
            for (int j = i; j < n - i; j++) {
                list.add(matrix[i][j]);
            }

            // 从上到下
            for (int j = i + 1; j < m - i; j++) {
                list.add(matrix[j][n - i - 1]);
            }

            // 从右到左
            // 如果这一层只有一行，则前面从左到右已经打印过该行，此处不再打印
            for (int j = n - i - 2; j >= i && (m - i - 1 != i); j--) {
                list.add(matrix[m - i - 1][j]);
            }

            // 从下到上
            // 如果这一层只有一列，则前面从上到下已经打印过该列，此处不再打印
            for (int j = m - i - 2; j >= i + 1 && (i != n - i - 1); j--) {
                list.add(matrix[j][i]);
            }
            i++;
        }

        return list;
    }

    public static void main(String[] args) {
        int[][] matrix1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        List list1 = spiralOrder(matrix1);
        for (int i = 0; i < list1.size(); i++) {
            System.out.print(list1.get(i) + " ");
        }

        System.out.println();

        int[][] matrix2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        List list2 = spiralOrder(matrix2);
        for (int i = 0; i < list2.size(); i++) {
            System.out.print(list2.get(i) + " ");
        }

        System.out.println();

        int[][] matrix3 = {{1, 2, 3, 4}};
        List list3 = spiralOrder(matrix3);
        for (int i = 0; i < list3.size(); i++) {
            System.out.print(list3.get(i) + " ");
        }

        System.out.println();

        int[][] matrix4 = {{1}, {2}, {3}, {4}};
        List list4 = spiralOrder(matrix4);
        for (int i = 0; i < list4.size(); i++) {
            System.out.print(list4.get(i) + " ");
        }
    }
}
