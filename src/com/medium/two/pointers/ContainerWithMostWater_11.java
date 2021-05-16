package com.medium.two.pointers;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/5/16 10:12
 * <p>
 * 11. 盛最多水的容器
 **/
public class ContainerWithMostWater_11 {
    public static int maxArea(int[] height) {
        // 双指针i,j分别指向容器两端，每次向内移动短板，更新最大面积值，直到两个指针相遇，返回最大面积值

        // 为什么是每次向内移动短板呢？
        // 因为容器面积等于短板高度乘以底边宽度，无论向内移动短板还是长板，底边宽度都将减一。
        // 如果向内移动短板，短板可能变大，容器面积因此可能变大；
        // 如果向内移动长板，短板可能不变或变小，容器面积一定变小。
        // 因此应该每次向内移动短板，寻找最大面积值。

        int i = 0, j = height.length - 1, s = 0;

        while (i < j) {
            int tmp = Math.min(height[i], height[j]) * (j - i);
            s = Math.max(s, tmp);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return s;
    }

    public static void main(String[] args) {
        int[] height1 = {1, 1};
        int[] height2 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height1));
        System.out.println(maxArea(height2));
    }
}
