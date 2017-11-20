package com.jack.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
Reshape the Matrix
# Description
	In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.
	You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.
	The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.
	If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
# Example
	Input: 
	nums = 
	[[1,2],
	 [3,4]]
	r = 1, c = 4
	Output: 
	[[1,2,3,4]]
Note:
	The height and width of the given matrix is in range [1, 100].
	The given r and c are all positive.
 */
public class A566_ReshapeMatrix {

	/**
	 * runtime:O(rc) 
	 * @param nums
	 * @param r
	 * @param c
	 * @return
	 */
	public int[][] matrixReshape(int[][] nums, int r, int c){
		int s = nums.length,t = nums[0].length;
		if(s*t != r*c)
			return nums;
		int[][] result = new int[r][c];
		for(int i = 0; i<r ; i++)
			for(int j = 0; j<c; j++)
				result[i][j] = nums[(i*c+j)/t][(i*c+j)%t];
		return result;
	}
	
	@Test
	public void test01(){
		int[][] nums ={{1,2,3},{3,4,3}}; 
		int r = 1, c = 4;
		int[][] result = matrixReshape(nums, r, c);
		System.out.println(result.length);
		System.out.println(result[0].length);
	}
	
	/*****************************************
	 * 其它作品展示
	 */
	/**
	 * runtime: O(rc)
	 * @param nums
	 * @param r
	 * @param c
	 * @return
	 */
	public int[][] matrixReshape02(int[][] nums, int r, int c) {
        int n = nums.length, m = nums[0].length;
        if (r*c != n*m) return nums;
        int[][] res = new int[r][c];
        for (int i=0;i<r*c;i++) 
            res[i/c][i%c] = nums[i/m][i%m];
        return res;
    }
}
