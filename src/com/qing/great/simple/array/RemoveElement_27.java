package com.qing.great.simple.array;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/1 19:51
 * <p>
 * 27. 移除元素
 **/
public class RemoveElement_27 {

    // 一.快慢指针
    // 按题意，可将每一个不需要移除的元素（即不等于目标值的元素）复制出来，并返回其个数。可利用快慢指针，具体的：
    // 1.初始化p，作为每个元素新的下标。初始化i，用于遍历数组。
    // 2.当遍历到的元素等于目标值时，p保持不动，将i移动到下一个元素。
    // 3.当遍历到的元素不等于目标值时，将p移动到下一个元素，将i对应的元素复制到p，将i移动到下一个元素。
    // 4.直到i遍历完数组，返回i+1作为数组的新长度。

    public static int removeElement_1(int[] nums, int val) {
        int p = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                p++;
                nums[p] = nums[i];
            }
        }

        return p + 1;
    }

    // 二.头指针尾指针
    // 方法一是将每一个不需要移除的元素复制出来。如果需要移除的元素个数很少，此时操作次数会很多。
    // 按题意，元素的顺序可以改变。从头开始遍历，遇到需要移除的元素，则从数组末尾开始找到不需要移除的元素将其覆盖。具体的：
    // 1.初始化head，用于从头遍历数组。初始化tail，指向最后一个元素。
    // 2.如果head遇到需要移除的元素，则用最后一个元素将其覆盖，并将tail向前移动。
    // 如果最后一个元素也是需要移除的元素，此时已将其复制到head的位置，在下一次循环中仍然会进行判断。
    // 3.如果head没有遇到需要移除的元素，将tail向前移动，直到head和tail相遇。
    // 4.返回head作为数组的新长度。
    // 赋值操作的次数等于要删除的元素的数量。因此，如果要移除的元素很少，效率更高。


    // 特别注意：循环条件、如果最后一个元素也是需要移除的元素。

    public static int removeElement_2(int[] nums, int val) {
        int head = 0;
        int tail = nums.length;

        while (head < tail) {
            if (nums[head] == val) {
                nums[head] = nums[tail - 1];
                tail--;
            } else {
                head++;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        int[] nums0 = {};

        int l0 = removeElement_2(nums0, 2);
        for (int i = 0; i < l0; i++) {
            System.out.print(nums0[i] + " ");
        }

        System.out.println();

        int[] nums1 = {0, 1, 2, 2, 1, 3, 0, 4, 2};

        int l1 = removeElement_2(nums1, 2);
        for (int i = 0; i < l1; i++) {
            System.out.print(nums1[i] + " ");
        }

        System.out.println();

        int[] nums2 = {0, 0, 0, 0, 0, 0, 0, 0, 0};

        int l2 = removeElement_2(nums2, 0);
        for (int i = 0; i < l2; i++) {
            System.out.print(nums2[i] + " ");
        }

        System.out.println();

        int[] nums3 = {0, 0, 0, 0, 0, 0, 0, 0, 0};

        int l3 = removeElement_2(nums3, 1);
        for (int i = 0; i < l3; i++) {
            System.out.print(nums3[i] + " ");
        }
    }

}
