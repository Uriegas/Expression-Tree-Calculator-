package com.spolancom;
/**
 * Node Class
 * Used in ExpressionTree
 * Abstract node
 */
public class Node<T>{
    T info;
    Node<T> left;
    Node<T> right;
    public Node(T data){
        this.info = data;
        this.right = null;
        this.left = null;
    }
    public void setInfo(T info){this.info = info;}
    public T getInfo(){return this.info;}
    public void setRight(Node<T> n){this.right = n;}
    public void setLeft(Node<T> n){this.left = n;}
    public Node<T> visitLeft(){
        return left;
    }
    public Node<T> visitRigth(){
        return right;
    }
}
