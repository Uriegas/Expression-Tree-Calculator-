package com.spolancom;
/**
 * Node Class
 * Used in ExpressionTree
 * Abstract node
 */
public class Node{
    Token info;
    Node left;
    Node right;
    public Node(Token data){
        this.info = data;
        this.right = null;
        this.left = null;
    }
    public Node(Node t){
        this.info = t.info;
        this.right = t.right;
        this.left = t.left;
    }
    public void setData(Token info){
        this.info = info;
    }
    public Token getData(){
        return info;
    }
    public void setRight(Node n){
        this.right = n;
    }
    public void setLeft(Node n){
        this.left = n;
    }
    public Node visitLeft(){
        return left;
    }
    public Node visitRigth(){
        return right;
    }
}
