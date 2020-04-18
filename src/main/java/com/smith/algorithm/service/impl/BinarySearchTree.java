package com.smith.algorithm.service.impl;

public class BinarySearchTree<K extends Comparable<K>,V> {

  private int count;
  private TreeNode<K,V> root;

  static class TreeNode<K,V> {
    private K key;
    private V value;

    private TreeNode<K,V> leftNode;
    private TreeNode<K,V> rightNode;

    public TreeNode(K key, V value) {
      this.key = key;
      this.value = value;
    }

    public K getKey() {
      return key;
    }

    public void setKey(K key) {
      this.key = key;
    }

    public V getValue() {
      return value;
    }

    public void setValue(V value) {
      this.value = value;
    }

    public TreeNode<K,V> getLeftNode() {
      return leftNode;
    }

    public void setLeftNode(TreeNode<K,V> leftNode) {
      this.leftNode = leftNode;
    }

    public TreeNode<K,V> getRightNode() {
      return rightNode;
    }

    public void setRightNode(TreeNode<K,V> rightNode) {
      this.rightNode = rightNode;
    }


  }

  public TreeNode<K,V> insert(K k, V v) {
    TreeNode<K,V> nextNode = root;
    while (nextNode != null) {
      if (nextNode.getKey().compareTo(k) > 0) {
        nextNode = nextNode.getRightNode();
      } else {
        nextNode = nextNode.getLeftNode();
      }
    }
    nextNode = new TreeNode<>(k, v);
    if (root == null) {
      root = nextNode;
    }
    return root;
  }

  public TreeNode<K,V> search(K k) {
    TreeNode<K,V> nextNode = root;

    return null;
  }

  public int size() {
    return count;
  }

  public boolean isEmpty() {
    return this.count == 0;
  }
}
