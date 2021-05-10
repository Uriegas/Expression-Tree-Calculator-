package com.spolancom;

enum Operand_Type{NUMBER, VARIABLE}

/**
 * Operand
 */
public class Operand extends Token {
    private Operand_Type type;
    public Operand(Operand_Type i){
        type = i;
    }
}