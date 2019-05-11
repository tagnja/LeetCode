package com.jack.leetcode.medium;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
Given two strings representing two complex numbers.

You need to return a string representing their multiplication. Note i2 = -1 according to the definition.

Example 1:
Input: "1+1i", "1+1i"
Output: "0+2i"
Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
Example 2:
Input: "1+-1i", "1+-1i"
Output: "0+-2i"
Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
Note:

The input strings will not have extra blank.
The input strings will be given in the form of a+bi, where the integer a and b will both belong to the range of [-100, 100]. And the output should be also in this form.
 * @author jiatg
 *
 */
public class A537_complexNumberMultiplication {

	public static void main(String[] args) {
		System.out.println(complexNumberMultiply("1+1i", "1+1i"));
		System.out.println(complexNumberMultiply("1+-1i", "1+-1i"));
	}
	
	/**
	 * result：第1次提交Accepted，beats 34%
	 */
	public static String complexNumberMultiply(String a, String b){
		/*
		 * 提取复数的a,b
		 */
		int a1 = 0, b1 = 0, a2 = 0, b2 = 0;
		String regex = "-?\\d+";
		Pattern p = Pattern.compile(regex);
		Matcher m1 = p.matcher(a);
		Matcher m2 = p.matcher(b);
		if(m1.find())
			a1 = Integer.parseInt(m1.group());
		if(m1.find())
			b1 = Integer.parseInt(m1.group());
		if(m2.find())
			a2 = Integer.parseInt(m2.group());
		if(m2.find())
			b2 = Integer.parseInt(m2.group());
		
		/*
		 * 进行乘法
		 */
		int flag = a1;
		a1 = a1 * a2 - b1 * b2;
		b1 = flag * b2 + b1 * a2;
		return a1+"+"+b1+"i";
	}
}
