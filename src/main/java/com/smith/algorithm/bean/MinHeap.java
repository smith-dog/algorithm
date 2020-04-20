package com.smith.algorithm.bean;

import java.util.Arrays;

/**
 * 堆
 * @author smith
 */
public class MinHeap<T extends Comparable<T>> {

  /**
   * 存储的数据
   */
  protected T[] data;
  /**
   * 元素个数
   */
  protected int count;
  /**
   * 堆容量
   */
  protected int capacity;

  /**
   * 构造函数, 构造一个空堆, 可容纳capacity个元素
   * @param capacity
   */
  public MinHeap(int capacity){
    data = (T[]) new Comparable[capacity < 16 ? 16 :capacity];
    count = 0;
    this.capacity = capacity;
  }

  /**
   * 构造函数, 传入arr数组并构建一个堆
   * @param arr 元素数组
   */
  public MinHeap(T[] arr){
    data = Arrays.copyOf(arr,arr.length);
    count = arr.length;
    this.capacity = arr.length;
    // 从count/2的节点开始做下沉操作
    for (int i = count>>1; i >= 0; i--) {
      shiftDown(i);
    }
  }

  /**
   * 返回堆中的元素个数
   * @return
   */
  public int size(){
    return count;
  }

  /**
   * 返回一个布尔值, 表示堆中是否为空
   * @return
   */
  public boolean isEmpty(){
    return count == 0;
  }

  /**
   * 像最大堆中插入一个新的元素 item
   * @param item
   */
  public void insert(T item){
    if (count +1 > capacity) {
      resize();
    }
    data[count++] = item;
    shiftUp(count);
  }

  /**
   * 弹出堆顶元素
   * @return
   */
  public T extractTop() {
    // 弹出
    if (count == 0) {
      return null;
    }
    // 交换最后一个元素
    T top = data[0];
    swap(0, --count);
    shiftDown(0);
    return top;
  }


  /**
   * 交换堆中索引为i和j的两个元素
   * @param i
   * @param j
   */
  private void swap(int i, int j){
    T t = data[i-1];
    data[i-1] = data[j-1];
    data[j-1] = t;
  }

  /**
   * 节点上浮
   * @param k
   */
  private void shiftUp(int k){
    while( k > 1 && data[(k>>1)-1].compareTo(data[k-1]) > 0 ){
      swap(k, k>>1);
      k >>= 1;
    }
  }

  /**
   * 节点下沉
   * @param k
   */
  private void shiftDown(int k){
    while (k<<1 <= count) {
      int j = k<<1;
      if (j+1 <= count && data[j].compareTo(data[j-1]) < 0) {
        j++;
      }
      if (data[k-1].compareTo(data[j-1]) <= 0) {
        break;
      }
      swap(k,j);
      k=j;
    }
  }

  private void resize() {
    int newSize = data.length * 2;
    data = Arrays.copyOf(this.data, newSize);
    capacity = newSize;
  }

  // 测试 MaxHeap
  public static void main(String[] args) {
    MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(100);
    int N = 50; // 堆中元素个数
    int M = 100; // 堆中元素取值范围[0, M)
    for( int i = 0 ; i < N ; i ++ ) {
      maxHeap.insert( new Integer((int)(Math.random() * M)) );
    }
    System.out.println(maxHeap.size());
  }
}
