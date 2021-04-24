package com.medium.array;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/7 19:40
 * <p>
 * 33. 搜索旋转排序数组
 * <p>
 * 整数数组nums按升序排列，数组中的值互不相同。
 * 在传递给函数之前，nums在预先未知的某个下标 k（0 <= k < nums.length）上进行了旋转，使数组变为[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如，[0,1,2,4,5,6,7]在下标3处经旋转后可能变为[4,5,6,7,0,1,2]。
 * 给你旋转后的数组nums和一个整数target，如果nums中存在这个目标值target，则返回它的下标，否则返回-1。
 **/
public class SearchInRotatedSortedArray_33 {

    // 有序数组被旋转后，变成了局部有序。如果从数组中间分成两部分，总有一部分是有序的。尝试使用变种二分查找：
    // 如果目标值在有序的部分，则在有序部分查找，否则在无序部分查找。
    public static int search(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }

        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left <= right) {
            mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return mid;
            }

            // 通过比较端点数据判断区间是否有序
            // 如果左边部分有序
            if (nums[left] <= nums[mid]) {
                // 判断目标值是否在有序部分
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
                // 如果右边部分有序
            } else {
                // 判断目标值是否在有序部分
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};

        System.out.println(search(nums1, 3));
        System.out.println(search(nums1, 4));
        System.out.println(search(nums1, 5));
        System.out.println(search(nums1, 6));
        System.out.println(search(nums1, 7));
        System.out.println(search(nums1, 0));
        System.out.println(search(nums1, 1));
        System.out.println(search(nums1, 2));

        System.out.println();

        int[] nums2 = {6, 7, 0, 1, 2, 4, 5};

        System.out.println(search(nums2, 3));
        System.out.println(search(nums2, 6));
        System.out.println(search(nums2, 7));
        System.out.println(search(nums2, 0));
        System.out.println(search(nums2, 1));
        System.out.println(search(nums2, 2));
        System.out.println(search(nums2, 4));
        System.out.println(search(nums2, 5));
    }
}
