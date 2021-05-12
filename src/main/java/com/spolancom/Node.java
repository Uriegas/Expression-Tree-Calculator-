package com.spolancom;
/**
 * Node Class
 * Used in ExpressionTree
 * Abstract node
 */
public class Node<Token>{
    Token info;
    Node<Token> left;
    Node<Token> right;
    public Node(Token data){
        this.info = data;
        this.right = null;
        this.left = null;
    }
    public void setData(Token info){
        this.info = info;
    }
    public Token getData(){
        return info;
    }
    public void setRight(Node<Token> n){
        this.right = n;
    }
    public void setLeft(Node<Token> n){
        this.left = n;
    }
    public Node<Token> visitLeft(){
        return left;
    }
    public Node<Token> visitRigth(){
        return right;
    }
}
