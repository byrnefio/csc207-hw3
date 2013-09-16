package edu.grinnell.csc207.byrnefio.hw3;

import java.math.BigInteger;


public class Calculator {

	/* 
	 * Reads a string containing a mathematical 
	 * expression and evaluates it from left to right
	 */
	public static BigInteger eval0 (String expression) {
	   BigInteger soFar;
	   String[] input = StringUtils.splitAt(expression, ' ');
	   if (input.length == 1) {
	       soFar = new BigInteger(expression);
		return soFar;
	   }
	   else {
	       soFar = new BigInteger(input[0]);
	       for (int i = 1; i<input.length - 1; i+=2) {
		   String operand = input[i];
			 switch(operand) {
			 case "+": soFar = soFar.add(new BigInteger(input[i+1]));
			 break;
			 case "-": soFar = soFar.add(new BigInteger(input[i+1]));
			 break;
			 case "*": soFar = soFar.add(new BigInteger(input[i+1]));
			 break;
			 case "/": soFar = soFar.add(new BigInteger(input[i+1]));
			 break;
			 case "^": soFar = soFar.add(new BigInteger(input[i+1]));
			 break;	
			 }
	       } //for
	   return soFar;
	   } //else
	} //eval0

	/* 
	 * Calculates the fewest number of coins of specific 
	 * denominations needed to make change for the value
	 * given
	 */
	public static int[] fewestCoins (int payment) {
		return null;
	} //fewestCoins

	
	public static void main(String [] args) {
	    System.out.println(eval0("1 + 2 + 3 + 50"));
	    System.out.println(eval0("156"));
	}
} //Calculator
