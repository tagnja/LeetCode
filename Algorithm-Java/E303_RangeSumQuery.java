package com.jack.leetcode.easy;

/**
description:
	Given an integer array nums, find the sum of the elements between indices i and j (i �� j), inclusive.
Example:
	Given nums = [-2, 0, 3, -5, 2, -1]
	sumRange(0, 2) -> 1
	sumRange(2, 5) -> -1
	sumRange(0, 5) -> -3
solution:
	range(x,y) represent array subscript , -> x represent the sum of number in this range.
 * @author TaogenJia
 *
 */
public class A303_RangeSumQuery {
	
	private int[] nums;
    public A303_RangeSumQuery(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        int result=0;
        for(int x=i;x<=j;x++){
            result += nums[x];
        }
        return result;
    }
    public static void main(String[] args) {
    	int[] array = {1,2,3,4,5,6,7,12,123,123,43,45,46,57,57,67,34,3,3,3,3,3,22,0,21,1,0};
		A303_RangeSumQuery t4 = new A303_RangeSumQuery(array);
		System.out.println(t4.sumRange(4,6));
	}
}
