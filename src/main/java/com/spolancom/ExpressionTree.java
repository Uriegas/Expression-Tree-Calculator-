package com.spolancom;

enum Pos{LEFT, RIGHT}
/**
 * Expression Tree
 * 
 */
public class ExpressionTree<T>{
    private Node<T> root;
    public ExpressionTree(){
        root = null;
    }
    public ExpressionTree(T init_val){
        root = new Node<T>(init_val);
    }
    public void Add(Node<T> p, Node<T> c, Pos pos){
        if(pos == Pos.LEFT)
            p.setLeft(c);
        else
            p.setRight(c);
    }
}
