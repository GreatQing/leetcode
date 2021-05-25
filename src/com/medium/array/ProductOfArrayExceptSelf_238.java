package com.medium.array;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/5/25 21:23
 * <p>
 * 238. 除自身以外数组的乘积
 **/
public class ProductOfArrayExceptSelf_238 {
    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;

        int[] res = new int[length];

        res[0] = 1;
        // 计算nums[i]左侧所有数字的乘积
        for (int i = 1; i < length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int temp = 1;
        for (int i = length - 2; i >= 0; i--) {
            // 计算nums[i]右侧所有数字的乘积
            temp = temp * nums[i + 1];
            // 计算左侧与右侧乘积
            res[i] = res[i] * temp;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4};
        int[] res = productExceptSelf(ints);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
