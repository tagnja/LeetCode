package com.jack.leetcode.easy;

import org.junit.Test;

public class A521_LongestUncommonSubsequenceI {


	/**
	 * 想了很久，结果就是这么简单。还是没有审好题。正常aabb,ab，结果应该是2，leetcode结果为4。
	 * discuss上最热门的评论是：“I feel this problem is just perfect for April Fools' day”
	 * 解题的思路：
	 * 字符串长度不一样，长的字符串就是结果。
	 * 字符串长度一样，对应的字符有一个不相同，结果就会改长度。对应的字符全都相同，结果为-1。
	 * runtime：12%.
	 * @param a
	 * @param b
	 * @return
	 */
	public int findLUSlength(String a, String b) {
		int NoUncommon = -1;
		if(a.length()!=b.length())
			return a.length() > b.length() ? a.length() : b.length();
		else{
			for(int i = 0; i < a.length(); i++){
				if(a.charAt(i)!=b.charAt(i)){
					return a.length();
				}
			}
			return NoUncommon;
		}
	}
	
	@Test
	public void test01(){
		String a = "aaa";
		String b = "aab";
		System.out.println(findLUSlength(a,b));//3
		
		String a2 = "aba";
		String b2 = "cdc";
		System.out.println(findLUSlength(a2,b2));//3
		
		String a3 = "aaa";
		String b3 = "aaa";
		System.out.println(findLUSlength(a3,b3));//-1
		
		
		String a4 = "aefawfawfawfaw";
		String b4 = "aefawfeawfwafwaef";
		System.out.println(findLUSlength(a4, b4));//17
		
		String a5 = "";
		String b5 = "";
		System.out.println(findLUSlength(a5, b5));//-1
	}
	
	/*****************************************************/
	/**
	 * 优秀作品01
	 */
	public int findLUSlength01(String a, String b) {
	    return a.equals(b) ? -1 : Math.max(a.length(), b.length());
	}
}
