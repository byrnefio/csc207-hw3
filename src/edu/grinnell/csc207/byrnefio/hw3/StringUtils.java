package edu.grinnell.csc207.byrnefio.hw3;
import java.io.PrintWriter;
public class StringUtils {

	/*
	 * Splits a string into an array of substrings
	 * separated by a particular character
	 */
    public static String[] splitAt(String splitText, char splitChar) {
	int[] separator = new int[splitText.length()];
	int j = -1;
	String split = "" + splitChar;  // [1] 
	for (int i = 0; i <splitText.length(); i++) {
	    String var = splitText.substring(i, i+1);
	    if (var.equals(split)) {
		j++;
		separator[j] = i; //contains the indices of every separator character
	    } //if
	} //for
	
	//returns the original string if the separator character never occurs
	String[] result = new String[j+2];
	if (separator[0]==0 && !split.equals(splitText.substring(0,1))) {
	    result[0]=splitText;
		    return result;
	} //if
	
	//creates an array of substrings based on the location of
	// the separator characters
	for (int k = 0; k < (j+2); k++) {
	    if (k == 0) //is the first segment
		result[k] = splitText.substring(0, separator[k]);
	    else if (k == (j + 1)) //is the last segment
		result[k] = splitText.substring(separator[k-1]+1);
	    else //is any other segment
		result[k] = splitText.substring(separator[k-1]+1, separator[k]);
	}
	return result;
    } //splitAt
	
	/*
	 * Splits a string into an array of substrings
	 * using a comma as the separator and 
	 */
	public static String[] splitCSV(String splitText) {
	    int[] separator = new int[splitText.length()];
	    int j = -1;
	    String split = ",";  
	    for (int i=0;i<splitText.length();i++) {
		boolean inside = false;
		String var = splitText.substring(i, i+1);
		if (var.equals(split)) {
		    j++;
		    separator[j] = i; //contains the indices of every separator character
		} //if
	    } //for


	    String[] result = new String[j+2];
	    if (separator[0]==0 && !split.equals(splitText.substring(0,1))) {
		result[0]=splitText;
		return result;
	    }

	    for (int k = 0; k < (j+2); k++) {
		if (k == 0) //is the first segment
		    result[k] = splitText.substring(0, separator[k]);
		else if (k == (j + 1)) //is the last segment
		    result[k] = splitText.substring(separator[k-1]+1);
		else
		    result[k] = splitText.substring(separator[k-1]+1, separator[k]);
	    }
	    return result;
	} //splitCSV
	
	/*
	 *  Converts a string from leet to plaintext
	 */
	public static String deLeet (String leet) {
	    
	    String deleeted = "nothing yet";
	    return deleeted;	
	} //deLeet

	
	/*
	 * Takes any English name beginning with a capital letter and
	 * returns a verse of The Name Game by Shirley Ellis using
	 * that name
	 */
	public static void nameGame (String name)  {
	    PrintWriter pen = new PrintWriter(System.out, true);
	    //digraph phonemes
	    String sh = "Sh";
	    String ch = "Ch";
	    String th = "Th";
	    String ph = "Ph";
	    String end;
	    
	    String test = name.substring(0, 2);
	    String test2 = name.substring(0,1);
	    
	    //vowels
	    String a = "A";
	    String e = "E";
	    String i = "I";
	    String o = "O";
	    String u = "U";
	    
	    //if the name begins with a digraph phoneme remove the first two letters
	    if (test.equals(sh) || test.equals(ch) || test.equals(th) 
		    || test.equals(ph)) {
		end = name.substring(2);
	    }
	    //if the name begins with a vowel, remove no letters
	    else if (test2.equals(a) || test2.equals(e) || test2.equals(i) || 
		    test2.equals(o) || test2.equals(u))
		end = name.toLowerCase();
	    //in all other cases, remove the first letter
	    else 
		end = name.substring(1);
	    
	    //print a verse using the name
	    pen.println(name + "!");
	    pen.println(name + ", " + name + " bo B" + end + 
		    " Boanna fanna fo F" + end);
	    pen.println("Fee fy mo M" + end + ", " + name + "!");
	} //nameGame
	
	public static void main(String [] args) {
	    //testing nameGame
	    nameGame("Shirley");
	    nameGame("Lincoln");
	    nameGame("Olivia");
	} // main
	


} //StringUtils

/*
 * Citations
 * [1]: Making a character into a string from
 * Bellora, Paul (2011). How to Convert a Char to a String in Java?. StackOverflow. Available at:
 *  http://stackoverflow.com/questions/8172420/how-to-convert-a-char-to-a-string-in-java 
 *  (Last modified 14 August 2013; Visited 13 September 2013. 
 */
