package com.category.search;

/**
 * @Author qiwenbo
 * @Date 2021/7/31 11:46
 * @Description 二分查找的两种方式，迭代和递归
 **/
public class BinarySearch {

    /**
     * 非递归方式
     *
     * @param array
     * @param target
     * @return
     */
    public int search(int array[], int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (target < array[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 递归方式实现
     *
     * @param nums
     * @param start
     * @param end
     * @param target
     * @return
     */
    public int searchB(int nums[], int start, int end, int target) {
        if (end >= start) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                return searchB(nums, start, mid - 1, target);
            } else {
                return searchB(nums, mid + 1, end, target);
            }
        }
        return -1;
    }
}
