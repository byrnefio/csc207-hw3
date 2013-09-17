/**
 * @author - Fiona Byrne
 * @author - John Brady
 * Homework #3
 * 2013-09-16
 * CSC207, Rebelsky
 */
package edu.grinnell.csc207.byrnefio.hw3;

import java.math.BigInteger;
import java.util.Arrays;





public class Calculator {

	/* 
	 * Reads a string containing a mathematical 
	 * expression and evaluates it from left to right
	 * considering only +, -, *, /, and ^ operands
	 */
	public static BigInteger eval0 (String expression) {
	   BigInteger soFar;
	   //creates an array with each even element as a number and each odd as an operator
	   String[] input = StringUtils.splitAt(expression, ' ');
	   //returns input if given only a number
	   if (input.length == 1) {
	       soFar = new BigInteger(expression);
		return soFar;
	   }
	   else {
	       //sets initial BigInt as first input element, the first number
	       soFar = new BigInteger(input[0]);
	       //cycles through operators (by starting at input[1] and applying each operator
	       for (int i = 1; i<input.length - 1; i+=2) {
		   String operator = input[i];
			 switch(operator) {
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
		int[] change = {0,0,0,0}; //starting values of change
		int elements = payment; //upper limit of number of coins used. more later.
		
		//cannot compute change for these values
		if (payment == 1 || payment == 3 || payment == 5) {
		    int[] error = {-1,-1,-1,-1};
		    return error;
		}
		else {
		    /*okay, now for the good stuff. 
		     * This algorithm will look at every possible combination of coins.
		     * The number of these combinations is payment^4 (as of now)
		     * When it finds a combination of coins whose sum returns payment with no remainder,
		     * we also look to see how many coins it took to compute that sum.
		     * The starting number of coins is the value of payment, the absolute maximum value.
		     * This way, the first correct combination will set the new "record," and each following
		     * combination will have to use fewer coins in order to update the output array.
		     * We will end having tested every possible combination, and we only output the shortest
		     * combination of coins that would generate the correct answer.
		     * NOTE: This becomes unusably slow very quickly, so be careful. (Up to XXX tested to be safe)
		     */
		    for( int deck = 0;deck<=(payment/54);deck++)
			for(int stickpair = 0;stickpair<=(payment/11);stickpair++)
			    for(int eater = 0;eater<=(payment/7);eater++)
				for(int wot = 0;wot<=(payment/2);wot++)
				    if(payment == (2*wot + 7*eater + 11*stickpair + 54*deck) &&
				    (wot+eater+stickpair+deck<=elements)){
					change[0]=wot;
					change[1]=eater;
					change[2]=stickpair;
					change[3]=deck;
					elements=wot+eater+stickpair+deck;
				    }   
		}

		return change;
		
	} //fewestCoins
	
	public static void main(String [] args) {
	    System.out.println(Arrays.toString(fewestCoins(3)));
	    System.out.println(Arrays.toString(fewestCoins(20)));
	    System.out.println(Arrays.toString(fewestCoins(28)));
	    System.out.println(Arrays.toString(fewestCoins(7)));
	    System.out.println(Arrays.toString(fewestCoins(44)));
	    System.out.println(Arrays.toString(fewestCoins(16)));
	    System.out.println(Arrays.toString(fewestCoins(65)));
	    System.out.println(Arrays.toString(fewestCoins(1800)));
	}
} //Calculator
