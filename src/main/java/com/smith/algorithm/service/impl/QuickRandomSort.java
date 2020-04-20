package com.smith.algorithm.service.impl;

import com.smith.algorithm.service.AbstractSort;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.stereotype.Component;

/**
 * 快速排序随机基准优化
 * @author smith
 */
@Component
public class QuickRandomSort <T extends Comparable<T>> extends AbstractSort<T>{

  ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();

  @Override
  public void sort(T[] arr) {
    int n = arr.length;
    sort(arr, 0, n-1);
  }

  public void sort(T[] arr , int left , int right){
    if (left >= right) {
      return;
    }

    // 获取一个随机基准并且和left交换
    swap(arr, left, threadLocalRandom.nextInt(left, right));
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
