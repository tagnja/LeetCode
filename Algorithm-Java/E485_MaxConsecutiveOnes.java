package com.jack.leetcode.easy;

import org.junit.Test;

public class A485_MaxConsecutiveOnes {
	/**
	 * runtime:O(n) = n,42%;
	 * @param nums
	 * @return
	 */
	public int findMaxConsecutiveOnes(int[] nums) {
        int begin = 0, end = 0, max = 0;
        for(int i = 0; i < nums.length; i++){
            if(0 != nums[i]){
                begin = i;
                System.out.println("begin:"+begin);
                end = findEnd(nums,i);
                System.out.print("end:"+end);
                i = end + 1;
                if((end-begin+1)>max)
                    max = end - begin + 1;
            }
        }
        return max;
    }
    public int findEnd(int[] nums, int  i){
        for(; i < nums.length; i++){
            if(0 == nums[i]){
            	System.out.println("a");
                return i-1;
            }
        }
        if((nums.length) == i){
        	System.out.println("b");
            return nums.length - 1;
        }
        System.out.println("c");
        return i;
    }
    @Test
    public void test01(){
    	int[] nums = {1};
    	System.out.println("result:"+findMaxConsecutiveOnes(nums));
    }
}
