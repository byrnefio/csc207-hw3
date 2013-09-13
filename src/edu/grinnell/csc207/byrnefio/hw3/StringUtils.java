package edu.grinnell.csc207.byrnefio.utils;

public class StringUtils {

	/*
	 * Splits a string into an array of substrings
	 * separated by a particular character
	 */
    public static String[] splitAt(String splitText, char splitChar) {
	int[] separator;
	int j = -1;
	for (int i=0;i<splitText.length();i++) {
	    String var = splitText.substring(i, i+1);
	    if (var.equals(splitChar)) {
		j++;
		separator[j] = i;
	    } //if
	} //for
	
	String[] result = new String[j+1];
	for (int k = 0; k < j; k++) {
	    if (k == 0) //is the first segment
		result[k] = splitText.substring(0, separator[k]);
	    else if (k == (j - 1)) //is the last segment
		result[k] = splitText.substring(separator[k]+1, splitText.length() - 1);
	    else
		result[k] = splitText.substring(separator[k-1]+1, separator[k]);
	}
	return result;
    } //splitAt
	
	/*
	 * Splits a string into an array of substrings
	 * using a comma as the separator and 
	 */
	public static String splitCSV(String splitText) {
		return null;
	} //splitCSV
	
	/*
	 *  Converts a string from leet to plaintext
	 */
	public static String deLeet (String leet) {
		return null;
	} //deLeet
	
	public static String nameGame (String name)  {
		return null;
	} //nameGame

} //StringUtils
