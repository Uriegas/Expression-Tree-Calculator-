package com.spolancom;

enum Operand_Type{NUMBER, VARIABLE}

/**
 * Operand
 */
public class Operand extends Token {
    private Operand_Type type;
    private Double data;
    public Operand(Operand_Type i, double j){
        type = i;
        data = Double.valueOf(j);
    }
    public Operand(Operand_Type i, float j){
        type = i;
        data = Double.valueOf(j);
    }
    public Operand(Operand_Type i, int j){
        type = i;
        data = Double.valueOf(j);
    }
}