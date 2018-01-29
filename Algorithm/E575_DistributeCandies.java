package com.jack.leetcode.easy;

import java.util.HashSet;

import org.junit.Test;

/**
 * # Description
 * Given an integer array with even length
 * , where different numbers in this array represent different kinds of candies. 
 * Each number means one candy of the corresponding kind. 
 * You need to distribute these candies equally in number to brother and sister. 
 * Return the maximum number of kinds of candies the sister could gain.
 * 有一组偶数个数字，每种数字代表一种糖果，把这些糖果平均分给姐姐和弟弟，返回姐姐获取糖果种类最多是几种。
 * 
 * # Example
 * Input: candies = [1,1,2,2,3,3]
 * Output: 3
 * 
 * Note:
 * The length of the given array is in range [2, 10,000], and will be even.
 * The number in given array is in range [-100,000, 100,000].
 * 
 */
public class A575_DistributeCandies {

	
	/**
	 * 解题思路：怎么标记重复的数值。或者过滤重复的数值。
	 * accept：1 time
	 * runtime：O(n2) beat 0.04%
	 */
	public int distributeCandies(int[] candies) {
		int count = 0;
        for(int i = 0; i < candies.length; i++){
        	if(candies[i]!=-111111){
        		for(int j = i+1; j < candies.length; j++){
        			if(candies[j]==candies[i]){
        				candies[j] = -111111;
        				count++;
        			}
        		}
        	}
        }
        count = (count<=(candies.length/2)) ? candies.length/2 : candies.length-count;
		return count;
    }
	@Test
	public void test01(){
		int[] candies01 = {100000,0,100000,0,100000,0,100000,0,100000,0,100000,0};
		int[] candies = {1,1,2,3,3,5};
		System.out.println(distributeCandies03(candies01));
		
	}
	/*****************************************************************
	 * 其它作品展示
	 */
	/**
	 * 作品1：O(n)
	 * 将整数值加入HaseSet，自动过滤重复值。
	 */
	public int distributeCandies01(int[] candies) {
		HashSet<Integer> kind = new HashSet<Integer>();
		for(int candy : candies)
			kind.add(candy);
		return kind.size()>= candies.length/2 ? candies.length/2 : kind.size();
	}
	/**
	 * 作品2：O(n)
	 * 将整数值当作数组的下标。重复的下标对应的不是初始值。
	 */
	public int distributeCandies02(int[] candies) {
		int b[] = new int[200001];
		int nonEmptyBucketNo  = 0;
		for(int i : candies)
			if(b[i+100000]++==0)   
				nonEmptyBucketNo ++;
		return nonEmptyBucketNo <=candies.length/2 ? nonEmptyBucketNo : candies.length/2 ;
	}
	/**
	 * 作品3： O(n)
	 * 方法和作品2类似
	 */
	public int distributeCandies03(int[] candies) {
		boolean[] b = new boolean[200001];
		int nonEmptyBucketNo  = 0;
		for(int i : candies)
			if(b[i+100000]==false){
				nonEmptyBucketNo ++;
				b[i+100000] = true;
			}
		return nonEmptyBucketNo<=candies.length/2 ? nonEmptyBucketNo : candies.length/2;
	}
}
