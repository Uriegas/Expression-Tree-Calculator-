package com.spolancom;
/**
 * Stores numbers or operators
 */
public class Terms {
    /**
     * Number or result of operation
     */
    private float value;
    /**
     * Operator(+,-,/,*,sin,cos,tan)
     * This could be a char if trig funcs are converted as chars
     */
    private String operator;
    /**
     * It is a number
     */
    public Terms(float value){this.value = value;}
    /**
     * It is an operator
     */
    public Terms(String operator){this.operator = operator;}
}
