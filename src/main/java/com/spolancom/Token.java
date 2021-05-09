package com.spolancom;

enum Token_type{NUMBER, FUNCTION}
enum Func_Type{ADD, SUB, MUL, DIV, POW, SQRT, SIN, COS, TAN}

public class Token {
    public Token_type type;
    public Token_type type(){
        return type;
    }
}

/**
 * Number
 */
public class Number extends Token {
    public Number(){
        type = Token_type.NUMBER;
    }
}

/**
 * Function
 */
public class Function extends Token {
    private Func_Type func_type;

    public Function(){
        type = Token_type.FUNCTION;
    }
    public int precedence(){
        if(this.func_type == Func_Type.ADD || this.func_type == Func_Type.SUB)
            return 3;
        else if(this.func_type == Func_Type.MUL || this.func_type == Func_Type.DIV)
            return 2;
        else //Unary operators
            return 1;
    }
}