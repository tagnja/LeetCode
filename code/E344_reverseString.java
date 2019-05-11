package com.jack.leetcode.easy;

/**
Description:
	Write a function that takes a string as input and returns the string reversed.

Example:
	Given s = "hello", return "olleh".
	
	Subscribe to see which companies asked this question


 * @author TaogenJia
 *
 */
public class A344_reverseString {

	public String reverseString(String s) {
    	char[] a = s.toCharArray();
    	for(int i=0;i<a.length/2;i++){
    		char f = a[a.length-1-i];
    		a[a.length-1-i] = a[i];
    		a[i] = f;
    	}
    	return new String(a);
    }
}
