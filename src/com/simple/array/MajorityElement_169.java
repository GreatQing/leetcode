package com.simple.array;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/18 21:51
 * <p>
 * 169. 多数元素
 **/
public class MajorityElement_169 {

    // 根据题意，多数元素的个数大于n/2，其他元素个数总和小于等于n/2，则多数元素个数减去其他元素个数总和必将大于等于1。
    // 可以让多数元素跟其他元素两两进行相互抵消，到最后肯定剩余至少一个多数元素。
    public static int majorityElement(int[] nums) {
        // 初始化第一个元素为候选者
        int n = nums[0];

        // 初始化其票数为1
        int c = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == n) {
                // 如果当前值与候选者相同，则候选者票数+1
                ++c;
            } else if (--c == 0) {
                // 如果当前值与候选者不同，则候选者票数-1
                // 且如果当前值票数为0，更换候选者为当前值，并将其票数初始化为1
                n = nums[i];
                c = 1;
            }
        }

        return n;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1, 2, 2, 1, 1}));
        System.out.println(majorityElement(new int[]{3, 2, 3}));
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
        System.out.println(majorityElement(new int[]{-1, 0, 1, 1, 1}));
        System.out.println(majorityElement(new int[]{0, 1, 1, 1, 2}));
    }
}
