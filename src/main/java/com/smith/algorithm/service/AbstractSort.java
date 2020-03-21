package com.smith.algorithm.service;

import org.springframework.stereotype.Component;

/**
 *
 * @author smith
 */
public abstract  class AbstractSort {

  /**
   * 排序
   * @param arr 排序对象数组
   * @param <T> 实现Comparable接口，可以用于对比
   */
  public abstract <T extends Comparable<T>> void sort(T[] arr);

  protected void swap(Object[] arr, int i , int j) {
    Object t = arr[i];
    arr[i] = arr[j];
    arr[j] = t;
  }

}
