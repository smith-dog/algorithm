package com.smith.algorithm.service.impl;

import com.smith.algorithm.service.AbstractSort;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.stereotype.Component;

/**
 * 三路快排
 *
 * @author smith
 */
@Component
public class Quick3WaysSort <T extends Comparable<T>> extends AbstractSort<T>{

  ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();

  @Override
  public void sort(T[] arr) {
    int n = arr.length;
    sort(arr, 0, n - 1);
  }

  public void sort(T[] arr, int left, int right) {
    if (left >= right) {
      return;
    }
    // 获取一个随机基准并且和left交换
    swap(arr, left, threadLocalRandom.nextInt(left, right));

    // 左标识--》小于基准值
    // 右标识--》大于基准值

    int lt  = left;
    int gt = right + 1;
    int i = left + 1;
    // 选择最左节点为基准一个基准
    while (i < gt) {
      if (arr[i].compareTo((T) arr[left]) < 0) {
        swap(arr, i, lt+1);
        i ++;
        lt ++;
      } else if (arr[i].compareTo((T) arr[left]) > 0) {
        swap(arr, i,  gt-1);
        gt--;
      } else {
        i++;
      }
    }

    // 交换基准
    swap(arr, left, lt);

    // 拆分递归
    sort(arr, left, lt -1);
    sort(arr, gt, right);
  }

}
