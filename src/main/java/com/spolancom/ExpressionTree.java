package com.spolancom;


/**
 * Expression Tree
 * 
 */
public class ExpressionTree {
    enum Pos {
        LEFT, RIGHT
    }
    private Node<Token> root;

    public ExpressionTree() {
        root = null;
    }

    public ExpressionTree(Token init_val) {
        root = new Node<Token>(init_val);
    }

    public Node<Token> Add(Node<Token> n) {
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
    public double evaluate(Node<Token> root){
        if(root == null)
            return (double)0.0;
        else if ( (root.getLeftNode() == null) && (root.getRigthNode() == null) )
            return root.getData().getNumber();
        double left = evaluate(root.getLeftNode());
        double rigth = evaluate(root.getRigthNode());

        return eval(left, rigth, root.getData());

    }

    public double eval(Token a, Token b, Token operation){
        switch (operation.getType()) {
            case ADD: return ( a.getNumber() + b.getNumber() );
            case SUB: return ( a.getNumber() - b.getNumber() );
            case MUL: return ( a.getNumber() * b.getNumber() );
            case DIV: return ( a.getNumber() / b.getNumber() );
            case POW: return ( Math.pow(a.getNumber(), b.getNumber()) );
            case SQRT: return ( Math.sqrt(a.getNumber()) );
            case SIN: return ( Math.sin(a.getNumber()) );
            case COS: return ( Math.cos(a.getNumber()) );
            case TAN: return ( Math.tan(a.getNumber()) );
        }
    }
}
