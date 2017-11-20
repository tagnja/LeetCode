package com.jack.leetcode.easy;

import org.junit.Test;

/**
 * @author jiatg
# Description
	Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.
	The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.
# Example
	Input: "UD"
	Output: true
	Input: "LL"
	Output: false
 */
public class A657_JudgeRouteCircle {

	/**
	 * 思路1：判断字符串中有几个U对一个几个D，几个L对应几个R。
	 * 将字符串转换为字符数组。遍历数组判断对应的字符，统计字符个数。
	 * O(n)
	 * @param moves
	 * @return
	 */
	public boolean judgeCircle(String moves){
		int UCount = 0, DCount = 0, LCount = 0, RCount = 0;
		for(char c : moves.toCharArray()){
			if('U' == c)
				UCount++;
			else if('D' == c)
				DCount++;
			else if('L' == c)
				LCount++;
			else 
				RCount++;
		}
		//System.out.println(UCount+","+DCount+","+LCount+","+RCount);
		if(UCount == DCount && LCount == RCount)
			return true;
		return false;
	}
	@Test
	public void test01(){
		System.out.println(judgeCircle("UD"));
		System.out.println(judgeCircle("LL"));
	}
}
