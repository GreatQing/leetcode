package com.medium.array;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/5/16 15:18
 * <p>
 * 59. 螺旋矩阵 II
 **/
public class SpiralMatrixII_59 {

    public static int[][] generateMatrix(int n) {
        // 生成一个空矩阵，然后模拟整个顺时针填入的过程
        int[][] res = new int[n][n];

        // 设置左、右、上、下边界
        int l = 0, r = n - 1, t = 0, b = n - 1;
        // 设置初始值i=1，迭代终止值num=n*n
        int i = 1, num = n * n;

        // 当i<=num时，始终按照从左到右、从上到下、从右到左、从下到上的顺序填入矩阵
        while (i <= num) {
            // 从左到右
            for (int j = l; j <= r; j++) {
                // 每次填充完成后数字i加1
                res[t][j] = i++;
            }
            // 更新边界，边界内缩
            t++;

            // 从上到下
            for (int j = t; j <= b; j++) {
                res[j][r] = i++;
            }
            r--;

            // 从右到左
            for (int j = r; j >= l; j--) {
                res[b][j] = i++;
            }
            b--;

            // 从下到上
            for (int j = b; j >= t; j--) {
                res[j][l] = i++;
            }
            l++;
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] res = generateMatrix(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
