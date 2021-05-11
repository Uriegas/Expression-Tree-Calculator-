package com.spolancom;

enum Token_Type{
    ADD, SUB, MUL, DIV, POW, SQRT, SIN, COS, TAN, //Operators
    NUMBER, VARIABLE, //Operands
    ASSOCIATIVE_RIGTH, ASSOCIATIVE_LEFT,//Agrupators
    UNDEFINED //Undefined type aka ERROR
}

public class Token {
    private Token_Type type;
    private Object value;

    public Token(Double v){
        type = Token_Type.NUMBER;
        value = v;
    }

    public Token(String v){
        value = v;
        switch(v){//Maybe here we need a try catch
            case "+": type = Token_Type.ADD; break;
            case "-": type = Token_Type.SUB; break;
            case "*": type = Token_Type.MUL; break;
            case "/": type = Token_Type.DIV; break;
            case "^": type = Token_Type.POW; break;
            case "sqrt": type = Token_Type.SQRT; break;
            case "sin": type = Token_Type.SIN; break;
            case "cos": type = Token_Type.COS; break;
            case "tan": type = Token_Type.TAN; break;
            case "(": type = Token_Type.ASSOCIATIVE_LEFT; break;
            case "[": type = Token_Type.ASSOCIATIVE_LEFT; break;
            case ")": type = Token_Type.ASSOCIATIVE_RIGTH; break;
            case "]": type = Token_Type.ASSOCIATIVE_RIGTH; break;
            case "x": type = Token_Type.VARIABLE; break;
            default: type = Token_Type.UNDEFINED; break;
        }
    }
    public Object getNumber(){
        if(type == Token_Type.NUMBER)
            return value;
        else
            return null;
    }

    public Token_Type getType(){return type;}

    public int precedence(){
        if(type == Token_Type.MUL || type == Token_Type.DIV)
            return 3;
        else if(type == Token_Type.ADD || type == Token_Type.SUB)
            return 2;
        else if(type == Token_Type.POW)//Binary operators
            return 1;
        else //Unary operators
            return 0;
    }

    public boolean leftAssociative(){
        if( type == Token_Type.ADD || type == Token_Type.SUB ||
            type == Token_Type.MUL || type == Token_Type.DIV )
            return true;
        else
            return false;
    }
    public boolean rigthAssociative(){
        return !this.leftAssociative();
    }
    public boolean equals(Token t){
        if(this.type == t.type && this.value == t.value)
            return true;
        else
            return false;
    }
    public String toString(){
        return value.toString();
    }
}