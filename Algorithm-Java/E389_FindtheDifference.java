package com.jack.leetcode.easy;

import org.junit.Test;

public class A389_FindtheDifference {

	/**
	 * runtime:O(n) = n^2 , 0.1%
	 * @param s
	 * @param t
	 * @return
	 */
	public char findTheDifference(String s, String t) {
		for(int i = 0; i < s.length(); i++)
			t = t.replaceFirst("["+s.charAt(i)+"]", "-");
		for(char c : t.toCharArray())
			if(c!='-')
				return c;
		return ' ';    
    }
	
	@Test
	public void test01(){
		System.out.println(findTheDifference("abcd","abcde"));
		System.out.println(findTheDifference("","a"));
	}
	
	/************************************/
	
	/**
	 * 其他解答01: O(n) = n
	 */
	public char findTheDifference01(String s, String t) {
		int n = t.length();
		char c = t.charAt(n - 1);
		for (int i = 0; i < n - 1; ++i) {
			c ^= s.charAt(i);
			c ^= t.charAt(i);
		}
		return c;
	}
}
