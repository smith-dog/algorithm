package com.smith.algorithm.service.impl;

import com.smith.algorithm.service.AbstractSort;
import java.util.Arrays;
import org.springframework.stereotype.Component;

/**
 * 归并自底向上实现
 * @author smith
 */
@Component
public class MergeBottomUpSort <T extends Comparable<T>> extends AbstractSort<T> {

  @Override
  public void sort(T[] arr) {
    int len = arr.length;
    // 自底向上
    T[] temp = Arrays.copyOf(arr, arr.length);
    for (int step = 1; step <= len; step += step) {
      // 划分区间
      for (int index = 0; index < len; index += step + step) {
        int l = index, mid = index+step-1, r= Integer.min(index+step+step-1, len-1);
        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
          // 如果左半部分元素已经全部处理完毕
          if (i > mid) {
            arr[k] = temp[j];
            j++;
          } else if (j > r) {
            // 如果右半部分元素已经全部处理完毕
            arr[k] =  temp[i];
            i++;
          } else if (temp[i].compareTo(temp[j]) < 0) {
            // 左半部分所指元素 < 右半部分所指元素
            arr[k] = temp[i];
            i++;
          } else {  // 左半部分所指元素 >= 右半部分所指元素
            arr[k] = temp[j];
            j++;
          }
        }
      }
    }
  }
}
