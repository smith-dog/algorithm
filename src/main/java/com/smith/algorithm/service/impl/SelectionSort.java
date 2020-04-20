package com.smith.algorithm.service.impl;

import com.smith.algorithm.service.AbstractSort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 选择排序
 * @author smith
 */
@Slf4j
@Component
public class SelectionSort <T extends Comparable<T>> extends AbstractSort<T> {

  @Override
  public void  sort(T[] arr) {
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      // 寻找[i, n)区间里的最小值的索引
      int minIndex = i;
      for (int j = i + 1; j < n; j++) {
        // 使用compareTo方法比较两个Comparable对象的大小
        if (arr[minIndex].compareTo(arr[j]) > 0) {
          minIndex = j;
        }
      }
      swap(arr, i, minIndex);
    }
  }
}
