package com.smith.algorithm.service.impl;

import com.smith.algorithm.service.AbstractSort;
import org.springframework.stereotype.Component;

/**
 * 原地堆排序
 * @author smith
 */
@Component
public class HeapSort <T extends Comparable<T>> extends AbstractSort<T> {

  @Override
  public void sort(T[] arr) {
    // 从count/2的节点开始做下沉操作
    for (int i = (arr.length-1)>>1; i >= 0; i--) {
      shiftDown(arr, arr.length, i);
    }

    for (int i = arr.length-1 ; i > 0; i--) {
      swap(arr, i, 0);
      shiftDown(arr, i, 0);
    }

  }

  /**
   * 节点下沉
   * @param k
   * @param length
   */
  private void shiftDown(T[] arr, int length, int k){
    while (k<<1 <= length) {
      int j = k<<1;
      if (j+1 <= length && arr[j].compareTo(arr[j-1]) > 0) {
        j++;
      }
      if (arr[k-1].compareTo(arr[j-1]) >= 0) {
        break;
      }
      swap(arr, k-1, j-1);
      k=j;
    }
  }

}
