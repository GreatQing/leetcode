package com.simple.array;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/1 21:20
 * <p>
 * 283. 移动零
 **/
public class MoveZeroes_283 {

    // 如果当前元素是0，则找到下一个不是0的元素，并交换。
    // 特别注意：交换时不能简单地将另一个元素赋值为0。否则数组开头是非零元素时进行交换会不正确。
    // 如果交换时想将另一个元素赋值为0，需要避免数组开头是非零元素时进行交换，也就是阻止（i==p）时交换。

    public static void moveZeroes(int[] nums) {
        int p = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int n = nums[p];
                nums[p] = nums[i];
                nums[i] = n;
                p++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums0 = {0, 1, 0, 12, 2, 0, 5};

        moveZeroes(nums0);

        for (int i = 0; i < nums0.length; i++) {
            System.out.print(nums0[i]);
        }

        System.out.println();

        int[] nums1 = {1};

        moveZeroes(nums1);

        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i]);
        }

        System.out.println();

        int[] nums2 = {0};

        moveZeroes(nums2);

        for (int i = 0; i < nums2.length; i++) {
            System.out.print(nums2[i]);
        }
    }
}
