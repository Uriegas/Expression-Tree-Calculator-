package com.spolancom;

import java.util.ArrayList;

/**
 * Scientific Calculator Application Code
 * 
 */
public class App 
{
    public static void main( String[] args )
    {
        String s = "sin(10)+10";
        Calculator c = new Calculator();
       ArrayList<Token> t = c.Tokenizer(s);
        System.out.println(t);
    }
}
