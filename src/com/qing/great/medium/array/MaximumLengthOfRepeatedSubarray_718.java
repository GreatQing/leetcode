package com.qing.great.medium.array;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/17 16:24
 * <p>
 * 718. 最长重复子数组
 **/
public class MaximumLengthOfRepeatedSubarray_718 {

    // 超出时间限制
    public static int findLength1(int[] nums1, int[] nums2) {
        int l = 0;

        for (int i = 0; i < nums1.length; i++) {
            int m = i;
            int k = 0;

            for (int j = 0; j < nums2.length; j++) {
                int n = j;
                while (m < nums1.length && n < nums2.length && nums1[m] == nums2[n]) {
                    m++;
                    n++;
                    k++;
                    l = Math.max(k, l);
                }

                m = i;
                k = 0;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        int[] n1 = {1, 2, 3, 2, 1};
        int[] n2 = {3, 2, 1, 4, 7};
        int[] n3 = {0, 1, 1, 1, 1};
        int[] n4 = {1, 0, 1, 0, 1};
        int[] n5 = {0, 0, 0, 0, 0, 0, 1, 0, 0, 0};
        int[] n6 = {0, 0, 0, 0, 0, 0, 0, 1, 0, 0};
        System.out.println(findLength1(n1, n2));
        System.out.println(findLength1(n3, n4));
        System.out.println(findLength1(n5, n6));
    }
}
