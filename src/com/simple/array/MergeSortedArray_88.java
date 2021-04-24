package com.simple.array;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/5 18:14
 * <p>
 * 88. 合并两个有序数组
 **/
public class MergeSortedArray_88 {

    // 考虑从后向前遍历，每次取数组nums1和nums2中较大的值放进数组nums1的最后面。
    // 特别注意：如果数组nums1初始的元素个数为0个，或数组nums1中的元素已经取完，则之后全部取数组nums2中的元素。
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m - 1;
        int q = n - 1;

        for (int i = m + n - 1; i >= 0; i--) {
            if (p < 0 && q >= 0) {
                nums1[i] = nums2[q--];
            } else if (p >= 0 && q >= 0 && nums1[p] >= nums2[q]) {
                nums1[i] = nums1[p--];
            } else if (p >= 0 && q >= 0 && nums1[p] < nums2[q]) {
                nums1[i] = nums2[q--];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 0};
        int m = 1;
        int[] nums2 = {5};
        int n = 1;

        merge(nums1, m, nums2, n);

        for (int i = 0; i < m + n; i++) {
            System.out.print(nums1[i]);
        }
    }
}
