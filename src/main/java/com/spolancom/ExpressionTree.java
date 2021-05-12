package com.spolancom;

import java.util.Stack;


/**
 * Expression Tree
 * 
 */
public class ExpressionTree<T> {
    enum Pos {
        LEFT, RIGHT
    }
    private Node<T> root;

    public ExpressionTree() {
        root = null;
    }

    public ExpressionTree(T init_val) {
        root = new Node<T>(init_val);
    }

    public Node<T> Add(Node<T> n) {
        if (n == null)
            root = n;
        else{
            
        }
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
