package com.jack.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.Test;

/**
Description
	You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
	
	The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.

Example 1:
	Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
	Output: [-1,3,-1]
	Explanation:
	    For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
	    For number 1 in the first array, the next greater number for it in the second array is 3.
	    For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
Example 2:
	Input: nums1 = [2,4], nums2 = [1,2,3,4].
	Output: [3,-1]
	Explanation:
	    For number 2 in the first array, the next greater number for it in the second array is 3.
	    For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
Note:
	All elements in nums1 and nums2 are unique.
	The length of both nums1 and nums2 would not exceed 1000.
 * @author jiatg
 *
 */
public class A496_NextGreaterElementI {

	/**
	 * 思路：找到nums2中与nums1相等的数,假设为a，判断a后面的数是否存在大于这个数的，有就赋值给result，并立刻break；
	 * runtime:26%;
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public int[] nextGreaterElement(int[] nums1, int[] nums2){
		int[] result = new int[nums1.length];
		for(int a = 0; a < nums1.length; a++)
			result[a] = -1;
		for(int i = 0; i < nums1.length; i++)
			for(int j = 0; j < nums2.length-1; j++){
				if(nums1[i]==nums2[j] ){
					for(int k = j+1; k < nums2.length; k++)
						if(nums2[k]>nums2[j]){
							result[i] = nums2[k];
							break;
						}
				}
			}
		return result;
	}
	
	@Test
	public void test01(){
		int[] num1 = {4,1,2}, num2 = {1,3,4,2},num3={},num4={1,3,5,2,4},num5={6,5,4,3,2,1,7};
		for(int a : nextGreaterElement(num1,num2))
			System.out.println(a);
		System.out.println("---------------");
		for(int a : nextGreaterElement(num4,num5))
			System.out.println(a);
	}
	
	/****************************************************************/
	
	/**
	 * O(n)
	 */
	public int[] nextGreaterElement01(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            stack.push(num);
        }   
        for (int i = 0; i < findNums.length; i++)
            findNums[i] = map.getOrDefault(findNums[i], -1);
        return findNums;
    }
}
