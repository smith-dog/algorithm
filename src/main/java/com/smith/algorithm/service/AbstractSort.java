package com.smith.algorithm.service;

import org.springframework.stereotype.Component;

/**
 *
 */
public abstract class AbstractSort {

  /**
   *
   * @param arr
   * @param
   */
  public abstract <T> void sort(Comparable<T>[] arr);

  protected void swap(Object[] arr, int i , int j) {
    Object t = arr[i];
    arr[i] = arr[j];
    arr[j] = t;
  }

}
