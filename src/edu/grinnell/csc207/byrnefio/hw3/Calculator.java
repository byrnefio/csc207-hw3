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
			 case "-": soFar = soFar.subtract(new BigInteger(input[i+1]));
			 break;
			 case "*": soFar = soFar.multiply(new BigInteger(input[i+1]));
			 break;
			 case "/": soFar = soFar.divide(new BigInteger(input[i+1]));
			 break;
			 case "^": soFar = soFar.pow(Integer.valueOf(input[i+1])); //from http://stackoverflow.com/a/5585876
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
} //Calculator
