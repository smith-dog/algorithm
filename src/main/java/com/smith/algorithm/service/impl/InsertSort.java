package com.smith.algorithm.service.impl;

import com.smith.algorithm.service.AbstractSort;
import org.springframework.stereotype.Component;

/**
 * @author smith
 */
@Component
public class InsertSort extends AbstractSort {

  @Override
  public <T extends Comparable<T>> void sort(T[] arr) {
    // 从第1个元素开始往前，如果比前面的元素小，那么交换位置
    for (int i = 0; i < arr.length; i++) {
      /// 写法1
      /*for (int j = i; j > 0 ; j--) {
        if (arr[j].compareTo(arr[j-1]) < 0) {
          swap(arr, j,j-1);
        } else {
          break;
        }

      }*/
      /// 写法2
      /*for( int j = i; j > 0 && arr[j].compareTo(arr[j-1]) < 0 ; j--) {
        swap(arr, j, j-1);
      }*/
      /// 写法3
      // 写法3 每次只进行覆盖，保存第i个i，顺序往前覆盖到结束后交换第i和结束点的值
      T e = arr[i];
      int j;
      for(j = i; j > 0 && arr[j-1].compareTo(e) > 0 ; j--) {
        arr[j] = arr[j-1];
      }
      arr[j] = e;
    }
  }
}
