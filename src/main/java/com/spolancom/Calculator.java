package com.spolancom;

import java.io.*;
import java.util.*;

/**
 * <h1>Calculator<h1/>
 * A scientific calculator from terminal
 * programmed in Java
 * @author Eduardo Uriegas
 * @version 1.0
 * @since 2021-06-06
 */
public class Calculator{
    /**
     * User input
     */
    private String in;
    /**
     * Expression Tree to store the user input abstractely
     * It is useful for making notation convertions and evaluation
     */
    private ExpressionTree<Token> tree = new ExpressionTree<Token>();
    private Float result;

    public Calculator(){
        in = null;
        tree = null;
        result = null;
    }


    public Float compute(){
        return result;
    }

    
    /**
     * Tokenizer
     * @param s
     * @return Array of tokens
     */
    public ArrayList<Token> Tokenizer(String s) throws IOException{
        s = s.toLowerCase();
        s = s.replaceAll(" ","");
        StreamTokenizer tk = new StreamTokenizer(new StringReader(s));
        tk.ordinaryChar('-');
        tk.ordinaryChar('/');
        ArrayList<Token> out = new ArrayList<Token>();

        while (tk.nextToken() != StreamTokenizer.TT_EOF) {
            switch(tk.ttype) {
                case StreamTokenizer.TT_NUMBER:
                    out.add( new Token(Double.valueOf(tk.nval)) );
                    break;
                case StreamTokenizer.TT_WORD:
                    out.add(new Token(tk.sval) );
                    break;
                default:  // operator
                    out.add( new Token(String.valueOf((char) tk.ttype)) );
            }
        }
        return out; 
    }

    /**
     * toRPN function
     * Converts an array of tokens to a stack in Reverse Polish Notation
     * This implements the Shunting Yard algorithm
     * @param ArrayList<Token> array of tokens
     * @return Stack<Token> RPN
     * Note: Doenst support syntax error detection yet
     */
    public Stack<Token> toRPN(ArrayList<Token> input){
        
        Stack<Token> operators = new Stack<>();
        Stack<Token> output = new Stack<>();
        for(int i = 0; i < input.size(); i++){//Iterate over tokens input
            if(input.get(i).op_type == false)//If it is a number
                output.push(input.get(i));
            else if(input.get(i).getType() == Type.LEFT)//If '('
                operators.push(input.get(i));
            else if(input.get(i).getType() == Type.RIGTH){//If ')'
                while(operators.peek() != Type.LEFT)
                    output.push(operators.pop());
                operators.pop();
            }
            else if(input.get(i).isOperand()){//If is an operand
                while( (output.peek().op_type == true) && 
                (operators.peek().precedence() >= input.get(i).precedence() ) )//Check precedence
                    output.push(operators.pop());
                operators.push(input.get(i));
            }
        }
        while(!operators.isEmpty())//While the stack has operator push them to the output
            output.push(operators.pop());
        return output;
    }

    public ArrayList<Token> instantiateVariables(ArrayList<Token> t, Scanner s){
        for(int i = 0; i < t.size(); i++){
            if(t.get(i).getType() == Token_Type.VARIABLE){
                System.out.print("Introduzca el valor de : ");
                Token tmp = new Token(s.nextLine());
                for(int j = i; j < t.size(); j++){
                    if(t.get(j).equals(tmp))
                        t.set(j, tmp);
                }
                break;//Remove break and we can implement multiple variables(ex. x, y, z)
            } 
        }
        return t;
    }

    /**
     * Function to convert an RPN stack onto an expression tree
     * @param in
     * @return ExpressionTree
     */
    public ExpressionTree<Token> toTree(Stack<Token> RPN){
        
    }

    /**
     * Just runs the calculator
     * @return Exit state
     */
    public int run(){
        Scanner s = new Scanner(System.in);
        System.out.println("Scientific Calculator");
        System.out.println("Enter something to compute");
        System.out.print("> ");
        //Save user input to in
        in = s.nextLine();
        this.compute();

        return 0;
    }
}