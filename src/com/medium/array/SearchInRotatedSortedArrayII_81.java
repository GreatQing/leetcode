package com.medium.array;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/7 20:17
 * <p>
 * 81. 搜索旋转排序数组 II
 **/
public class SearchInRotatedSortedArrayII_81 {
    // 在33题中，我们是通过比较端点数据判断区间是否有序。
    // 此题中，数组可以出现重复值，可能会出现n[left]=n[mid]=n[right]的情况，导致无法判断区间[left,mid]和[mid+1,right]哪个是有序的。
    // 此时，可以将left加1，将right减1，然后在新区间继续进行二分查找。
    // 时间复杂度是O(n)，最坏情况下数组所有元素都相等，且目标值不在数组中，此时所有值都查找了一遍。
    public static boolean search(int[] nums, int target) {
        if (nums == null) {
            return false;
        }

        if (nums.length == 1) {
            return nums[0] == target ? true : false;
        }

        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left <= right) {
            mid = (right - left) / 2 + left;

            if (nums[mid] == target) {
                return true;
            }

            // 当通过端点数据无法判断区间是否有序时，压缩区间，然后在新区间继续进行二分查找
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            }

            // 通过端点数据判断数据是否有序
            // 左边部分有序
            else if (nums[left] <= nums[mid]) {
                // 如果目标值在有序区间里
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // 右边部分有序
            else {
                // 如果目标值在有序区间里
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 5, 6, 0, 0, 1, 2};

        System.out.println(search(nums1, 2));
        System.out.println(search(nums1, 5));
        System.out.println(search(nums1, 6));
        System.out.println(search(nums1, 0));
        System.out.println(search(nums1, 1));
        System.out.println(search(nums1, 2));
        System.out.println(search(nums1, 3));
        System.out.println(search(nums1, 4));

        System.out.println();

        int[] nums2 = {3, 1, 2, 3, 3, 3, 3};

        System.out.println(search(nums2, 3));
        System.out.println(search(nums2, 1));
        System.out.println(search(nums2, 2));
        System.out.println(search(nums2, 0));

        System.out.println();

        int[] nums3 = {3, 3, 3, 3, 3, 3, 3};

        System.out.println(search(nums3, 3));
        System.out.println(search(nums3, 1));
    }
}
