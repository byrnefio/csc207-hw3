package edu.grinnell.csc207.byrnefio.hw3;

import static org.junit.Assert.*;
import java.math.BigInteger;


import org.junit.Test;

public class CalculatorTest {

    @Test
    public void test() {
	assertEquals(new BigInteger("0"), Calculator.eval0("0"));
	assertEquals(new BigInteger("2"), Calculator.eval0("1 + 1"));
	assertEquals(new BigInteger("4"), Calculator.eval0("1 + 2 + 1"));
	assertEquals(new BigInteger("9"), Calculator.eval0("1 + 2 * 3"));
	assertEquals(new BigInteger("8192"), Calculator.eval0("1 + 2 / 3 + 1 ^ 13"));
	assertEquals(new BigInteger("18446744073709551616"), Calculator.eval0("2 ^ 64"));
    }

}
