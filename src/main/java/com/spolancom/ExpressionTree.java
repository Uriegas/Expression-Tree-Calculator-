package com.spolancom;

import java.util.Queue;
import java.util.Stack;

/**
 * Expression Tree
 * 
 */
public class ExpressionTree {

    private Node root;

    public ExpressionTree() {
        root = null;
    }

    public ExpressionTree(Node t) {
        root = t;
    }

    public ExpressionTree(Queue<Token> RPN){
        root = RPNtoTree(RPN);
    }

    public Node RPNtoTree(Queue<Token> RPN){
        Stack<Node> tree = new Stack<>();
        for(Token t : RPN)//Iterate over RPN
            Add(t, tree);
        return tree.pop();
    }

    public void Add(Token n, Stack<Node> tree){
        if (n.isOperand())
            tree.push(new Node(n));
        else if(n.isBinary()){
            Node tmp = new Node(n);
            tmp.setLeft(tree.pop());
            try{tmp.setRight(tree.pop());}
            catch(Exception e){tmp.setRight(null);}
            tree.push(tmp);
        }
        else if(n.isUnary()){
            Node tmp = new Node(n);
            tmp.setRight(tree.pop());
            tree.push(tmp);
        }
    }

    /**
     * Converts RPN to ExpressionTree
     * @param RPN array of tokens without associative parenthesis
     * @return ExpressionTree<Token>
     */
    /*
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
*/
    /**
     * Compute tree
     * @return
     */
    public double compute(){
        return evaluate(root);
    }
    public double evaluate(Node root){
        if(root == null)
            return (double)0.0;
        else if ( (root.visitLeft() == null) && (root.visitRigth() == null) )
            return root.getData().getNumber();
        double left = evaluate(root.visitLeft());
        double rigth = evaluate(root.visitRigth());

        return eval(left, rigth, root.getData());

    }

    public Double eval(double a, double b, Token operation){
        switch (operation.getType()) {
            case ADD: return ( a + b );
            case SUB: return ( b - a );
            case MUL: return ( a * b );
            case DIV: return ( a / b );
            case POW: return ( Math.pow(a, b) );
            case SQRT: return ( Math.sqrt(b) );
            case SIN: return ( Math.sin(b) );
            case COS: return ( Math.cos(b) );
            case TAN: return ( Math.tan(b) );
            default: return null;
        }
    }
}
