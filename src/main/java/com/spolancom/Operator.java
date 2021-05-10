package com.spolancom;

enum Operator_Type{ADD, SUB, MUL, DIV, POW, SQRT, SIN, COS, TAN}
/**
 * Operator
 */
public class Operator extends Token {
    private Operator_Type type;

    public Operator(Operator_Type i){
        type = i;
    }
    public int precedence(){
        if(this.type == Operator_Type.ADD || this.type == Operator_Type.SUB)
            return 3;
        else if(this.type == Operator_Type.MUL || this.type == Operator_Type.DIV)
            return 2;
        else //Unary operators
            return 1;
    }
}