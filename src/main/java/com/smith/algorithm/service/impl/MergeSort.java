package com.smith.algorithm.service.impl;

import com.smith.algorithm.service.AbstractSort;
import java.util.Arrays;
import org.springframework.stereotype.Component;

/**
 * @author smith
 */
@Component
public class MergeSort extends AbstractSort {


  @Override
  public <T extends Comparable<T>> void sort(T[] arr) {
    int len = arr.length;
    // 自底向上
    Comparable[] temp = new Comparable[arr.length];
    for (int step = 1; step <= len; step <<= 1) {
      int offset = step + step;
      // 划分区间
      for (int index = 0; index < len; index += offset) {
        int leftStart = index;
        int rightStart = Integer.min(index + step, len - 1);
        int leftEnd = rightStart - 1;
        int rightEnd = Integer.min(index + offset - 1, len - 1);
        int mergeIndex = leftStart;
        int mergeLength = rightEnd - leftStart + 1;

        while (leftStart <= leftEnd || rightStart <= rightEnd) {
          if (leftStart > leftEnd) {
            temp[mergeIndex++] = arr[rightStart++];
          } else if (rightStart > rightEnd) {
            temp[mergeIndex++] = arr[leftStart++];
          } else {
            if (arr[leftStart].compareTo(arr[rightStart]) <= 0) {
              temp[mergeIndex++] = arr[leftStart++];
            } else {
              temp[mergeIndex++] = arr[rightStart++];
            }
          }
        }

        for (int i = 0; i < mergeLength; i++) {
          arr[index + i] = (T) temp[index + i];
        }
      }
    }
  }
}
