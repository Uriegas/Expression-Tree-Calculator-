package com.spolancom;

import java.util.ArrayList;
import java.util.Stack;

enum Pos {
    LEFT, RIGHT
}

/**
 * Expression Tree
 * 
 */
public class ExpressionTree<T> {
    private Node<T> root;

    public ExpressionTree() {
        root = null;
    }

    public ExpressionTree(T init_val) {
        root = new Node<T>(init_val);
    }

    public void Add(Node<T> p, Node<T> c, Pos pos) {
        if (pos == Pos.LEFT)
            p.setLeft(c);
        else
            p.setRight(c);
    }

    /**
     * Converts RPN to ExpressionTree
     * @param RPN array of tokens without associative parenthesis
     * @return ExpressionTree<Token>
     */
    public ExpressionTree<Token> RPN2Tree(Stack<Token> RPN) {
        Stack<Terms> c_stack = new Stack<Terms>();
        Stack<Terms> results = new Stack<Terms>();
        ExpressionTree<Token> tree = new ExpressionTree<>(RPN.pop());//Remove last object and insert in tree
        // Iterate over string in reverse
//        for (int i = RPN.size(); i < 0; i--) {
//            tree.
//        }
        for(Token i : RPN){
        //    if(isOperand(i))

        }
        return tree;
    }
}
