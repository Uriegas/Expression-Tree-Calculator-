package com.spolancom;
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
    private ExpressionTree<Integer> tree = new ExpressionTree<Integer>();

    public Calculator(){
        in = null;
        tree = null;
    }

    /**
     * Just runs the calculator
     * @return Exit state
     */
    public int run(){
        System.out.println("Scientific Calculator");
        return 0;
    }
}