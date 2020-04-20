package com.smith.algorithm.service;

import org.springframework.stereotype.Component;

/**
 *
 * @author smith
 */
public abstract class AbstractSort<T>{

  /**
   * 排序
   * @param arr 排序对象数组
   */
  public abstract void sort(T[] arr);

  protected void swap(Object[] arr, int i , int j) {
    Object t = arr[i];
    arr[i] = arr[j];
    arr[j] = t;
  }

}
