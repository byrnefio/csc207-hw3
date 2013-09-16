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
	 * using a comma as the separator and ignoring any
	 * commas between two quotation marks. Two quotation
	 * marks in a row are read as one.  
	 */
    public static String[] splitCSV(String splitText) {
	int separator = 0;
	
	String split = ",";
	String ignore = "\"";
	for (int i=0;i<splitText.length();i++) {
	    if(i<splitText.length()-1)
		if (ignore.equals(splitText.substring(i,i+1))) {
		    i++;
		    while(!(ignore.equals(splitText.substring(i,i+1)))){
			i++;
		    } //while
		} //if
	    String var = splitText.substring(i, i+1);
	    if (var.equals(split)) {
		separator++; //increment number of separating chars
	    } //if
	} //for
	
	int count = 0;
	String[] result = new String[separator+1]; //our output string array, of proper length

	StringBuffer buff = new StringBuffer(); //this is where we'll make strings before
						   //we push it to the result array 

	
	//traverse the string, adding to output array as we go
	for (int i = 0;i<splitText.length();i++){
	    //checks for the inQuote
	    if(ignore.equals(splitText.substring(i,i+1))){
		//checks if inQuote is actually a double, meaning read/append as a single
		if(ignore.equals(splitText.substring(i+1,i+2))){
		    i++;
		    buff.append(splitText.substring(i,i+1));
		}//if
		i++; //gets past the inQuote
		
		//moves through the inQuote area until outQuote
		while(!(ignore.equals(splitText.substring(i,i+1)))){
		    //checks for two subsequent quotes in the inQuote, appends char before double quote
		    //and then moves to last double quote
		    if(ignore.equals(splitText.substring(i+1,i+2))){
			if(ignore.equals(splitText.substring(i+2,i+3))){
			    buff.append(splitText.substring(i,i+1));
			    i+=2;
			} //if inner
		    } //if outer
		    //append a normal char/last double quote 
		    buff.append(splitText.substring(i,i+1));
		    i++;
		}//while
		i++; //gets past the outQuote
	    }//if
	    
	    //if separator, write buffer to array element, increment array, and clear buffer
	    if(split.equals(splitText.substring(i,i+1))){
		result[count]=buff.toString();
		count++;
		buff.delete(0, buff.length());
	    }else
		//appends next char
		buff.append(splitText.substring(i,i+1));
	    }//for
	result[count]=buff.toString(); //adds final buffer to array
	return result;
	} //splitCSV
	
	/*
	 *  Converts a string from leet to plaintext
	 */
	public static String deLeet (String leet){ //replaceAll didn't work, found solution here: http://stackoverflow.com/a/4105860
	    String output = leet.replace("|\\|","n");
	    output = output.replace("|3", "b");
	    output = output.replace("/v\\", "m");
	    output = output.replace("\\<", "k");
	    output = output.replace("|)", "d");
	    output = output.replace("|=", "f");
	    output = output.replace("+", "t");
	    output = output.replace("@", "a");
	    output = output.replace("3", "e");
	    output = output.replace("1", "l");
	    output = output.replace("0", "o");
	    output = output.replace("|", "i");
	    output = output.replace("#", "h");
	    output = output.replace("9", "g");
	    output = output.replace("(", "c");   
	    return output;	
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
	    
	    //testing deLeet
	    System.out.println(deLeet("3@+ |3@|\\|@|\\|@"));
	    
	} // main
	


} //StringUtils

/*
 * Citations
 * [1]: Making a character into a string from
 * Bellora, Paul (2011). How to Convert a Char to a String in Java?. StackOverflow. Available at:
 *  http://stackoverflow.com/questions/8172420/how-to-convert-a-char-to-a-string-in-java 
 *  (Last modified 14 August 2013; Visited 13 September 2013. 
 */
