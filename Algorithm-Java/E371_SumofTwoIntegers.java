package com.jack.leetcode.easy;

import org.junit.Test;

public class A371_SumofTwoIntegers {

	/**
	 * runtime:o(n) = n, 6%
	 * @param a
	 * @param b
	 * @return
	 */
	public int getSum(int a, int b) {
		int temp = 0;
		while((a & b) != 0){
			temp = b;
			b = (a & b) << 1;
			a = a ^ temp;
		}
        return a ^ b;
    }
	@Test
	public void test01(){
		System.out.println(getSum(2, 3));
		//Integer.parseInt("12", 2);
	}
	
}
