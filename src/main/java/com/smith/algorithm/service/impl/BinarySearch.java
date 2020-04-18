package com.smith.algorithm.service.impl;

/**
 * 二分搜索
 * @author smith
 */
public class BinarySearch {

  public int search(int[] array, int target) {
    //二分法
    int left = 0;
    int right = array.length-1;

    while (left <= right) {
      int mid = left + (right - left)/2;
      if (array[mid] == target) {
        return mid;
      }
      if (array[mid] > target) {
        right = mid -1;
      } else {
        left = mid +1;
      }
    }
    return -1;
  }

}
