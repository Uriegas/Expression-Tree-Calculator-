package com.spolancom;

import java.io.*;
import java.util.*;

/**
 * Scientific Calculator Application Code
 * 
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        //String s = "10+10";
        //String s = "sin(sqrt(3)) + 5";
        String s = "9/3/2";
  //      String s = "9*8-3";
  //     String s = "3x + sen(2x) - x^2 + sqrt(4)";
        Calculator c = new Calculator();
        ArrayList<Token> t = c.Tokenizer(s);
        System.out.println(t.toString());
        Scanner x = new Scanner(System.in);
        t = c.instantiateVariables(t, x);
        System.out.println(c.toRPN(t));
    }
}
