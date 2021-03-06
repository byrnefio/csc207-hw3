package edu.grinnell.csc207.byrnefio.hw3;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilsTest {

    @Test //splitAt
    public void testSplitAt() {
	
	assertArrayEquals(new String[] { "a", "b", "c" },
		StringUtils.splitAt("a:b:c", ':'));
	assertArrayEquals(new String[] { "a", "b", "c" },
		StringUtils.splitAt("a b c", ' '));
	assertArrayEquals(new String[] { "a:b:c" },
		StringUtils.splitAt("a:b:c", ' '));
	assertArrayEquals("one field", new String[] { "a" },
		StringUtils.splitAt("a", ':'));
	assertArrayEquals("empty inner field", new String[] { "a", "", "c" },
		StringUtils.splitAt("a::c", ':'));
	assertArrayEquals("leading empty field", new String[] { "", "a" },
		StringUtils.splitAt(":a", ':'));
	assertArrayEquals("trailing empty field", new String[] { "a", "" },
		StringUtils.splitAt("a:", ':'));
		
    } //testSplitAt
    
    @Test //splitCSV
    public void testSplitCSV(){
	assertArrayEquals(new String[] { "a", "b", "c" },
		StringUtils.splitCSV("a,b,c"));
	assertArrayEquals(new String[] { "a,b", "c" },
		StringUtils.splitCSV("\"a,b\",c"));	
	assertArrayEquals(new String[] { "a", "b,b\"", "c" },
		StringUtils.splitCSV("a,\"b,b\"\"\",c"));
    } //tesetSplitCSV
    
    @Test //deLeet
    public void testdeLeet(){
	assertEquals("e", StringUtils.deLeet("3"));
	assertEquals("leet", StringUtils.deLeet("133+"));
	assertEquals("eat banana", StringUtils.deLeet("3@+ |3@|\\|@|\\|@"));
	assertEquals("",StringUtils.deLeet(""));
    }
    
} //StringUtilsTest


