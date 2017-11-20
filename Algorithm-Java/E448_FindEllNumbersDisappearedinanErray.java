package com.jack.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class A448_FindAllNumbersDisappearedinanArray {

	/**
	 * 遍历数组，第i个数值与它正确的索引位置的数两两交换，遍历一次之后一半的元素回到正确的位置。两次就全部是正确的位置，除了重复的。
	 * 遍历数组，判断索引的数值是否是索引+1，不是就找到了缺少的值。
	 * @param nums
	 * @return
	 */
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> list = new ArrayList<>();
		if(nums.length == 0)
			return null;
		int i = 0, begin = nums[0],temp = 0;
		for(i = 0; i < nums.length; i++){
			if(nums[begin-1] != begin){
				temp = nums[begin-1];
				nums[begin-1] = begin ;
				begin = temp;
			}
		}
		for(i = 0; i < nums.length; i++)
			System.out.println((i+1)+","+nums[i]);
		for(i = 0; i < nums.length; i++)
			if((i+1) != nums[i])
				list.add(i+1);
		return list;
    }
	@Test
	public void test01(){
		int[] nums = {4,3,2,7,8,2,3,1};
		for(int i : findDisappearedNumbers(nums)){
			System.out.println("result:"+i);
		}
	}
}
