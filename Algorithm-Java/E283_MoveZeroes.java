package com.jack.leetcode.easy;

import org.junit.Test;

public class A283_MoveZeroes {
	public void moveZeroes(int[] nums) {
        int non = 0, zero = 0;
        while(non < nums.length ){
            while(non < nums.length && nums[non] == 0 )
            	non++;
            while(zero < nums.length && nums[zero] != 0)
            	zero++;
            if(non<nums.length && non > zero){
                nums[zero] = nums[non];
                nums[non] = 0;
                non++;
                zero++;
            }else
            	non++;
        }
    }
	@Test
	public void test(){
		int[] nums = {0,1};
		moveZeroes(nums);
		for(int i : nums)
		System.out.println(i);
	}
	/************************************/
	/**
	 * 其他作品01
	 * Simple O(N) Java Solution Using Insert Index
	 */
	public void moveZeroes01(int[] nums) {
	    if (nums == null || nums.length == 0) return;        
	    int insertPos = 0;
	    for (int num: nums) {
	        if (num != 0) nums[insertPos++] = num;
	    }        
	    while (insertPos < nums.length) {
	        nums[insertPos++] = 0;
	    }
	}
	/**
	 * 其他作品02
	 * 1ms Java solution
	 */
	public void moveZeroes02(int[] nums) {
	    int j = 0;
	    for(int i = 0; i < nums.length; i++) {
	        if(nums[i] != 0) {
	            int temp = nums[j];
	            nums[j] = nums[i];
	            nums[i] = temp;
	            j++;
	        }
	    }
	}
}
