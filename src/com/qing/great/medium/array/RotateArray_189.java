package com.qing.great.medium.array;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/2 19:02
 *
 * 189. 旋转数组
 * 给定一个数组，将数组中的元素向右移动k个位置，其中k是非负数。
 * 进阶：
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1)的原地算法解决这个问题吗？
 **/
public class RotateArray_189 {

    // 可以考虑每次只向右移动一个元素，总共移动k次。
    public static void rotate1(int[] nums, int k) {

        if (nums != null && nums.length > 1 && k > 0) {
            // k对数组长度取余数，因为向右移动k个和（k+length）个元素的效果是一样的
            int n = k % nums.length;
            for (int i = 0; i < n; i++) {
                int last = nums[nums.length - 1];
                for (int j = nums.length - 1; j > 0; j--) {
                    nums[j] = nums[j - 1];
                }

                nums[0] = last;
            }
        }
    }

    // k对数组长度取余数n，因为向右移动k个和（k+length）个元素的效果是一样的。
    // 可以考虑用一个长度为k的数组，将原数组后n个元素暂存起来。
    // 然后从数组尾开始复制（length-n）个元素，再从数组头开始复制刚才暂存的n个元素。
    public static void rotate2(int[] nums, int k) {

        if (nums != null && nums.length > 1 && k > 0) {
            int length = nums.length;
            int n = k % length;
            int[] temp = new int[n];

            // 暂存原数组后n个元素
            for (int i = 0; i < n; i++) {
                temp[i] = nums[length - n + i];
            }

            // 从数组尾开始复制（length-n）个元素
            for (int i = length - 1; i > n - 1; i--) {
                nums[i] = nums[i - n];
            }

            // 从数组头开始复制暂存的n个元素
            for (int i = 0; i < n; i++) {
                nums[i] = temp[i];
            }
        }
    }

    // 通过观察向右移动k个位置后的数组，可以通过先翻转整个数组元素，然后翻转前n个元素，最后翻转后（length-n）个元素来实现
    public static void rotate3(int[] nums, int k) {

        if (nums != null && nums.length > 1 && k > 0) {
            int length = nums.length;
            int n = k % length;

            // 翻转整个数组元素
            reverse(nums, 0, nums.length - 1);
            // 翻转前n个元素
            reverse(nums, 0, n - 1);
            // 翻转后（length-n）个元素
            reverse(nums, n, nums.length - 1);
        }
    }


    // 翻转数组nums从下标left到right的元素
    public static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i]);
        }

        System.out.println();

        rotate1(nums1, 3);

        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i]);
        }

        int[] nums2 = {1, 2};

        System.out.println();

        rotate2(nums2, 3);

        for (int i = 0; i < nums2.length; i++) {
            System.out.print(nums2[i]);
        }


        System.out.println();

        int[] nums3 = {1, 2, 3, 4, 5, 6, 7};
        for (int i = 0; i < nums3.length; i++) {
            System.out.print(nums3[i]);
        }

        System.out.println();

        rotate1(nums3, 3);

        for (int i = 0; i < nums3.length; i++) {
            System.out.print(nums3[i]);
        }

        System.out.println();

        int[] nums4 = {1, 2};

        for (int i = 0; i < nums4.length; i++) {
            System.out.print(nums4[i]);
        }

        System.out.println();

        rotate3(nums4, 3);

        for (int i = 0; i < nums4.length; i++) {
            System.out.print(nums4[i]);
        }
    }
}
