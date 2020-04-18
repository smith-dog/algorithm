package com.smith.algorithm.leedcode;

import java.util.Arrays;

/**
 * merge-k-sorted-lists
 */
class Solution23 {

  public static void main(String[] args) {

    //   [[-8,-7,-7,-5,1,1,3,4],[-2],[-10,-10,-7,0,1,3],[2]]
    ListNode[] listNodes = new ListNode[4];
    ListNode listNode1 = new ListNode(-8);
    listNode1.next = new ListNode(-7);
    listNode1.next.next = new ListNode(-7);
    listNode1.next.next.next = new ListNode(-5);
    listNode1.next.next.next.next = new ListNode(1);
    listNode1.next.next.next.next.next = new ListNode(1);
    listNode1.next.next.next.next.next.next = new ListNode(3);
    listNode1.next.next.next.next.next.next.next = new ListNode(4);

    ListNode listNode2 = new ListNode(-2);


    ListNode listNode3 = new ListNode(-10);
    listNode3.next = new ListNode(-10);
    listNode3.next.next = new ListNode(-7);
    listNode3.next.next.next = new ListNode(0);
    listNode3.next.next.next.next = new ListNode(1);
    listNode3.next.next.next.next.next = new ListNode(3);

    ListNode listNode4 = new ListNode(2);

    listNodes[0] = listNode1;
    listNodes[1] = listNode2;
    listNodes[2] = listNode3;
    listNodes[3] = listNode4;
    Solution23 solution23 = new Solution23();
    ListNode listNode = solution23.mergeKLists(listNodes);
    System.out.println(listNode);
  }

  public ListNode mergeKLists(ListNode[] lists) {
    ListNode listNode = null;
    ListNode listHeadNode = null;
    ListNode[] firstListNode = new ListNode[lists.length];
    int i = 0;
    for (ListNode list : lists) {
      // 从lists中抽取出一个Node节点构建最小堆
      if (list != null) {
        firstListNode[i++] = list;
      }
    }
    PriorityQueue q = new PriorityQueue(firstListNode);

    while (!q.isEmpty()) {
      // 开始弹出
      ListNode tempListNode = q.poll();
      if (listNode == null) {
        listNode = new ListNode(tempListNode.val);
        listHeadNode = listNode;
      } else {
        listNode.next = new ListNode(tempListNode.val);
        listNode = listNode.next;
      }
      if (tempListNode.next != null) {
        q.add(tempListNode.next);
      }
    }

    return listHeadNode;

  }

  static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  static class PriorityQueue {

    // 默认长度
    private ListNode[] queue = new ListNode[32];
    private int size;

    // 小顶堆构建
    public PriorityQueue(ListNode[] listNode) {
      if (listNode.length > queue.length) {
        queue = new ListNode[listNode.length];
      }
      int temp = 0;
      for (ListNode l : listNode) {
        if (l != null) {
          queue[temp++] = l;
          size++;
        }
      }
      if (isEmpty()) {
        return;
      }

      //System.arraycopy(listNode, 0, queue, 0, listNode.length);
      // 从非叶子节点开始下沉
      for (int i = size/2; i > 0 ; i--) {
        downNode(i);
      }
    }

    // 上浮节点
    public void upNode(int index) {
      int tempIndex = index;
      while (tempIndex > 1 && queue[tempIndex-1].val < queue[tempIndex/2-1].val) {
        swap(tempIndex, tempIndex/2);
        tempIndex /= 2;
      }
    }

    // 下沉节点
    public void downNode(int index) {
      while (2*index <= size) {
        int j = 2*index; // 在此轮循环中,data[k]和data[j]交换位置
        if( j+1 <= size && queue[j].val < queue[j-1].val) {
          j ++;
        }
        // data[j] 是 data[2*k]和data[2*k+1]中的最大值
        if(queue[index-1].val < queue[j-1].val) {
          break;
        }
        swap(index, j);
        index = j;
      }

    }

    public void add(ListNode node) {
      // 扩容
      if (size >= queue.length) {
        resize();
      }
      size++;
      queue[size-1] = node;
      upNode(size);
    }

    public ListNode poll() {
      ListNode listNode = queue[0];
      swap(1, size);
      size--;
      downNode(1);
      return listNode;
    }

    public boolean isEmpty() {
      return this.size == 0;
    }

    private void resize() {
      int newSize = queue.length * 2;
      queue = Arrays.copyOf(this.queue, newSize);
    }

    private void swap(int i, int j){
      ListNode t = queue[i-1];
      queue[i-1] = queue[j-1];
      queue[j-1] = t;
    }

  }

}