package com.jack.leetcode.easy;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.junit.Test;

/**
 * @author jiatg
 * Description:
 * Given an array of 2n Integer,your task is to group these integers into n pairs of integer
 * ,say (a1,b1),(a2,b2)...(an,bn)which makes sum of min(ai,bi) for all i from 1 to n as large as possible.
 * 将2n个数两个一组分成n组，使得分成的所有对中最小的数相加的和最大。max(sum) = min(a1,b1)+...+min(ai,bi)+...+min(an,bn).
 * Example
 * Input : [1,4,3,2]
 * Output:4
 * Explanation:n is 2,max sum of pairs is 4 , min(1,2)+min(3,4) = 1+3 = 4 ;
 * 1 2 4  7 8 10	
 * Solution:
 * 假设，假设有助于问题分析。假设ai <= bi
 * 将多个影响结果因素转换单个影响因素。如将一对数中求最小，所有最小数和最大两个因素变成每一对ai，bi距离最小。
 * sm = a1+a2+...+an, sa = (a1+b1)+(a2+b2)+...+(an+bn), sd = (b1-a1)+(b2-a2)+...+(bn-an)
 * sa = 2sm+sd , sm = (sa - sd)/2 , sa是确定的，sm最大，只要sd最小。
 * 考虑排好序的2n个数，2对，3对...n对，ai，bi如何组合距离和最小。（bi>ai）
 * 2对，4个数 n1<n2<n3<n4
 * 			a1 b1 a2 b2    (n2-n1)+(n4-n3)=min
 * 			a1 a2 b1 b2    (n3-n1)+(n4-n2)
 * 			a1 a2 b2 b1    (n4-n1)+(n3-n2)
 * 所以相邻的两个数两两组合sd最小
 */
public class A561_ArrayPartitionI {

	public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0;i<nums.length;i=i+2)
        	sum = sum + nums[i];
        return sum;
    }
	@Test
	public void test1(){
		int[] nums = {1,5,3,6,7,8};
		System.out.println("sum="+arrayPairSum(nums));
	}
}
