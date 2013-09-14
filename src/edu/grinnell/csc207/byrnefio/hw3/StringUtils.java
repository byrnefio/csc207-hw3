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
	String split = "" + splitChar;  // from http://stackoverflow.com/questions/8172420/how-to-convert-a-char-to-a-string-in-java
	for (int i=0;i<splitText.length();i++) {
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
		return null;
	} //deLeet
	
	
	
	public static void nameGame (String name)  {
	    PrintWriter pen = new PrintWriter(System.out, true);
	    String sh = "Sh";
	    String ch = "Ch";
	    String th = "Th";
	    String ph = "Ph";
	    String end;
	    String test = name.substring(0, 2);
	    String test2 = name.substring(0,1);
	    String a = "A";
	    String e = "E";
	    String i = "I";
	    String o = "O";
	    String u = "U";
	    if (test.equals(sh) || test.equals(ch) || test.equals(th) || test.equals(ph)) {
		end = name.substring(2);
	    }
	    else if (test2.equals(a) || test2.equals(e) || test2.equals(i) || test2.equals(o) || test2.equals(u))
		end = name.toLowerCase();
	    else 
		end = name.substring(1);
	    pen.println(name + "!");
	    pen.println(name + ", " + name + " bo B" + end + " Boanna fanna fo F" + end);
	    pen.println("Fee fy mo M" + end + ", " + name + "!");

	} //nameGame
	
	public static void main(String [] args) {
	    //testing nameGame
	    nameGame("Shirley");
	    nameGame("Lincoln");
	    nameGame("Olivia");
	}


} //StringUtils

