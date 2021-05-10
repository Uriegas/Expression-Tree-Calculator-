package com.spolancom;

enum Operator_Type{ADD, SUB, MUL, DIV, POW, SQRT, SIN, COS, TAN}
/**
 * Operator
 */
public class Operator extends Token {
    private Operator_Type type;

    public Operator(Operator_Type i){
        type = i;
        op_type = true;
    }
    public int precedence(){
        if(this.type == Operator_Type.ADD || this.type == Operator_Type.SUB)
            return 3;
        else if(this.type == Operator_Type.MUL || this.type == Operator_Type.DIV)
            return 2;
        else //Unary operators
            return 1;
    }
    public boolean isFunction(){
        try{
            if(this.type == Operator_Type.POW || this.type == Operator_Type.SQRT ||
            this.type == Operator_Type.SIN || this.type == Operator_Type.COS ||
            this.type == Operator_Type.TAN)
                return true;
            else
                return false;
        }
        catch(Error e){return false;}
    }
}