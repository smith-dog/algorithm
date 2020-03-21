package com.smith.algorithm.service.impl;

import com.smith.algorithm.service.AbstractSort;
import org.springframework.stereotype.Component;

/**
 * 该实现容易发生栈溢出
 * @author smith
 */
@Component
public class Quick3WaysSort extends AbstractSort {

  @Override
  public <T extends Comparable<T>> void sort(T[] arr) {
    int n = arr.length;
    sort(arr, 0, n-1);
  }

  public <T extends Comparable<T>> void sort(T[] arr , int left , int right){
    if (left >= right) {
      return;
    }

    // 获取一个随机基准并且和left交换

    // 选择一个基准
    int index = left;
    for (int i = left + 1; i <= right; i ++) {
      if (arr[i].compareTo(arr[left]) < 0) {
        swap(arr, i, ++index);
      }
    }
    // 交换基准
    swap(arr, left, index);

    // 拆分递归
    sort(arr, left, index -1 );
    sort(arr, index +1, right);
  }

}
