package com.spolancom;

/**
 * Type of parenthesis, could be parenthesis of
 * an agrupation or a function
 */
enum Agrupator_Type{ASSOCIATIVE_RIGTH, ASSOCIATIVE_LEFT, FUNC_RIGTH, FUNC_LEFT}

public class Agrupator extends Token{
    private Agrupator_Type type;
    public Agrupator(Agrupator_Type i){
        type = i;
        op_type = null;
    }
}
