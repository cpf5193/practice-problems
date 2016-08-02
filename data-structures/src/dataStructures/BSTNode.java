package dataStructures;

public class BSTNode<T> {
  T value;
  BSTNode<T> leftChild;
  BSTNode<T> rightChild;
  
  public BSTNode(T value) {
    this.value = value;
  }
  
  public BSTNode() {
    this(null);
  }
  
  public void setLeftChild (BSTNode<T> child) {
    leftChild = child;
  }
  
  public void setRightChild (BSTNode<T> child) {
    rightChild = child;
  }
  
  public BSTNode<T> getLeftChild() {
    return this.leftChild;
  }
  
  public BSTNode<T> getRightChild() {
    return this.rightChild;
  }
}
