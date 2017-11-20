package com.jack.leetcode.easy;

import org.junit.Test;

/**

# Description
	You are given a map in form of a two-dimensional integer grid 
	where 1 represents land and 0 represents water. 
	Grid cells are connected horizontally/vertically (not diagonally). 
	The grid is completely surrounded by water, and there is exactly one island 
	(i.e., one or more connected land cells). 
	The island doesn't have "lakes" (water inside that isn't connected to 
	the water around the island). One cell is a square with side length 1. 
	The grid is rectangular, width and height don't exceed 100. 
	Determine the perimeter of the island.
	计算岛的周长

# Example:
	[[0,1,0,0],
	 [1,1,1,0],
	 [0,1,0,0],
	 [1,1,0,0]]
	Answer: 16

 * @author jiatg
 *
 */
public class A463_IslandPerimeter {
	/**
	 * 思路：每个岛单元占4条边，与n个岛相连时，这个岛实际占4-n个边。岛的周长=所有的岛单元数目*4-所有岛单元相连的数目
	 * runtime:O(st)
	 * @param grid
	 * @return
	 */
	public int islandPerimeter(int[][] grid) {
		int count = 0,connectNum = 0;
		for(int i = 0; i<grid.length; i++)
			for(int j = 0; j<grid[0].length; j++)
				if(grid[i][j]==1){
					count++;
					if(i-1>=0 && grid[i-1][j] == 1)
						connectNum++;
					if(i+1<grid.length && grid[i+1][j] == 1 )
						connectNum++;
					if(j-1>=0 && grid[i][j-1] == 1)
						connectNum++;
					if(j+1<grid[0].length && grid[i][j+1] == 1)
						connectNum++;
				}
		return count = count * 4 - connectNum;
    }
	
	@Test
	public void test01(){
		int[][] a = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
		System.out.println(islandPerimeter(a));
	}
	/***********************************************************
	 * 其它展示
	 */
	
	/**
	 * 作品1
	 * runtime: O(st)
	 * loop over the matrix and count the number of islands;
	 *	if the current dot is an island, count if it has any right neighbour or down neighbour;
	 *	the result is islands * 4 - neighbours * 2
	 * @param grid
	 * @return
	 */
	public int islandPerimeter01(int[][] grid) {
        int islands = 0, neighbours = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islands++; // count islands
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbours++; // count down neighbours
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) neighbours++; // count right neighbours
                }
            }
        }
        return islands * 4 - neighbours * 2;
    }
	
	/**
	 * 作品2
	 * 和作品1思路一样。但变量更少。
	 * @param grid
	 * @return
	 */
	public static int islandPerimeter02(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    result += 4;
                    if (i > 0 && grid[i-1][j] == 1) result -= 2;
                    if (j > 0 && grid[i][j-1] == 1) result -= 2;
                }
            }
        }
        return result;
    }
}
