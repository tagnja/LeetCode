package com.jack.leetcode.easy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
Description:
Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.

Example 1:
Input: 5
Output: True
Explanation:
The binary representation of 5 is: 101
Example 2:
Input: 7
Output: False
Explanation:
The binary representation of 7 is: 111.
Example 3:
Input: 11
Output: False
Explanation:
The binary representation of 11 is: 1011.
Example 4:
Input: 10
Output: True
Explanation:
The binary representation of 10 is: 1010.

 * @author jiatg
 *
 */
public class A693_BinaryNumberwithAlternatingBits {

	public static void main(String[] args ){
		A693_BinaryNumberwithAlternatingBits test = new A693_BinaryNumberwithAlternatingBits();
		System.out.println(Integer.toBinaryString(((10>>1)^10)&(((10>>1)^10)+1)));
		System.out.println(Integer.toBinaryString(((11>>1)^11)&(((11>>1)^11)+1)));
		System.out.println(Integer.toBinaryString(5));
		/*
		 * 测试用例
		 */
		System.out.println(test.hasAlternatingBits3(5));//true
		System.out.println(test.hasAlternatingBits3(7));//false
		System.out.println(test.hasAlternatingBits3(11));//false
		System.out.println(test.hasAlternatingBits3(10));//true
	}
	/**
	 * 第1次提交
	 * 思路
	 * 找到连续不同的特征判断条件
	 * 将数字n转换成二进制字符串，然后匹配有没有连续的11..和00..
	 * 结果
	 * Accepted，beats 5%; 算法效率有点低。O(n) = n ,最好的应该是几次位运算就行了
	 */
	public boolean hasAlternatingBits(int n) {
        String s = Integer.toBinaryString(n);
        Pattern p = Pattern.compile("11|00");
        Matcher m = p.matcher(s);
        return !m.find();
    }
	
	/**
	 * #第1次提交
	 * 思路1：
	 * 通过位运算来处理连续两个位的不同。
	 * 结果1：
	 * fail，这个思路不对，(n & (n<<1)) == 0，原因是 1&0 和 0&0 都是0
	 * 
	 * #第2次提交
	 * 思路2：
	 * ((n >> 1) ^ n) ==111111 
	 * ((n >> 1) ^ n) ^ (((n >> 1) ^ n) + 1) ?==0
	 * 结果2：
	 * Accepted，beats 31%
	 * 勉强还可以，复杂度达到O(n)=1，感觉我的位运算有点复杂，应该有更优化的算法。
	 */
	public boolean hasAlternatingBits2(int n){
		if((((n >> 1) ^ n) & (((n >> 1) ^ n)+1)) == 0)
				return true;
		return false;
	}
	
	/**
	 * 第一次提交
	 * 优化了以下hasAlternatingBits2，重复进行两次位运算了，用一个变量赋值好一些
	 * 提交结果，beats 49%
	 */
	public boolean hasAlternatingBits3(int n){
		//写法1
		int a = (n >> 1) ^ n;
		if((a & ++a) == 0)
			return true;
		return false;
		
		//写法2
		/*int a = (n >> 1) ^ n; 
		return (a & ++a) == 0;*/
		
		//写法3，我觉得这个最好。复杂度和前面相同都是O(n)=1,变量更少，代码更精简。
		//return (((n >> 1) ^ n) & (((n >> 1) ^ n)+1)) == 0;//18ms,10%
	}
	
}
