package com.simple.binary.search;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/5/7 20:41
 *
 * 69. x 的平方根
 **/
public class SqrtX_69 {
    // 由于x平方根的整数部分ans是满足 k^2<=x 的最大k值，因此可以对k进行二分查找，从而得到答案。

    public int mySqrt(int x) {
        int l = 0, r = x;
        int ans = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }
}
