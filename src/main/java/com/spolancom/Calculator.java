package com.spolancom;
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
    private ExpressionTree<Terms> tree = new ExpressionTree<Terms>();
    private Float result;

    public Calculator(){
        in = null;
        tree = null;
        result = null;
    }


    public Float compute(){
        return result;
    }

    private boolean isNumber(char c){
        if( c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' ||
            c == '6' || c == '7' || c == '8' || c == '9' || c == '.' )
            return true;
        else
            return false;
    }
    private boolean isOperand(char c){
        if( c == '+' || c == '-' || c == '*' || c == '/' ||
            c == '^' || c == '!' || c == '@' || c == '#' || c == '$' )
            return true;
        else
            return false;
    }
    
    /**
     * Tokenizer
     * Converts string to an array of tokens
     */
    public ArrayList<Token> Tokenizer(String s){
        ArrayList<Token> tokens = new ArrayList<>();
        String number = "";
        /**
         * Replace functions names for char
         */
        s = s.toLowerCase();
        s = s.replaceAll(" ","");
        s = s.replaceAll("pow", "^");
        s = s.replaceAll("sin", "!");
        s = s.replaceAll("cos", "@");
        s = s.replaceAll("tan", "#");
        s = s.replaceAll("sqrt", "$");

        /**
         * Algorithm
         */
        boolean func_par_flag = false;

        for( int i = 0; i < s.length(); i++ ){
            //Is an operator
            if(s.charAt(i) == '+')
                tokens.add(new Operator(Operator_Type.ADD));
            else if(s.charAt(i) == '-')
                tokens.add(new Operator(Operator_Type.SUB));
            else if(s.charAt(i) == '*')
                tokens.add(new Operator(Operator_Type.MUL));
            else if(s.charAt(i) == '/')
                tokens.add(new Operator(Operator_Type.DIV));
            else if(s.charAt(i) == '^')
                tokens.add(new Operator(Operator_Type.POW));
            else if(s.charAt(i) == '!')
                tokens.add(new Operator(Operator_Type.SIN));
            else if(s.charAt(i) == '@')
                tokens.add(new Operator(Operator_Type.COS));
            else if(s.charAt(i) == '#')
                tokens.add(new Operator(Operator_Type.TAN));
            else if(s.charAt(i) == '$')
                tokens.add(new Operator(Operator_Type.SQRT));
            else if(s.charAt(i) == '('){
                if(tokens.get(tokens.size()-1).op_type){//If its an operator so a func parent
                    func_par_flag = true;
                    if(tokens.get(tokens.size()-1).isFunction())
                        tokens.add(new Agrupator(Agrupator_Type.FUNC_LEFT));
                    else
                        tokens.add(new Agrupator(Agrupator_Type.ASSOCIATIVE_LEFT));
                }
            }
            else if(s.charAt(i) == ')'){
                func_par_flag = false;
                if(func_par_flag){//If we have a func par in stack
                    tokens.add(new Agrupator(Agrupator_Type.FUNC_RIGTH));
                }
                else{
                    tokens.add(new Agrupator(Agrupator_Type.ASSOCIATIVE_RIGTH));
                }
            }
            else if(s.charAt(i) == '[')
                tokens.add(new Agrupator(Agrupator_Type.ASSOCIATIVE_LEFT));
            else if(s.charAt(i) == ']')
                tokens.add(new Agrupator(Agrupator_Type.ASSOCIATIVE_RIGTH));
            else if(this.isNumber(s.charAt(i))){//Is an operand aka number
                number += s.charAt(i);
                try{
                    if(!this.isNumber(s.charAt(i+1))){
                        tokens.add(new Operand(Operand_Type.NUMBER, Double.parseDouble(number)));
                        number = "";
                    }
                }catch(Exception e){//End of array and we got a number
                        tokens.add(new Operand(Operand_Type.NUMBER, Double.parseDouble(number)));
                }
            }
            else if(s.charAt(i) == 'x')
                tokens.add(new Operand(Operand_Type.VARIABLE));
        }
        
        return tokens;
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