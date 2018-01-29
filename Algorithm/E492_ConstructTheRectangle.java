package com.jack.leetcode.easy;

import org.junit.Test;

public class A492_ConstructTheRectangle {
	public int[] constructRectangle(int area) {
        int[] a = new int[2];
        int width = (int)Math.sqrt(area);
        while(width > 0){
            if(area % width == 0)
                break;
            width--;
        }
        a[0] = area/width;
        a[1] = width;
        return a;
    }
	@Test
	public void test(){
		for(int a:constructRectangle(12))
			System.out.println(a);
	}
	/************************************/
	/**
	 * 其他作品01
	 * 3 line Clean and easy understand solution
	 */
	public int[] constructRectangle01(int area) {
        int w = (int)Math.sqrt(area);
        while (area%w!=0) w--;
        return new int[]{area/w, w};
	}
}
