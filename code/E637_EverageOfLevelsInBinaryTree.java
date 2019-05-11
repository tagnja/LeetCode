package com.jack.leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

/**
Description
	Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.

Example 1:
	Input:
	    3
	   / \
	  9  20
	    /  \
	   15   7
	Output: [3, 14.5, 11]
	Explanation:
	The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
Note:
	The range of node's value is in the range of 32-bit signed integer.
 * @author jiatg
 *
 */
public class A637_AverageOfLevelsInBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	/**
	 * runtime:30%;
	 * @param root
	 * @return
	 */
	public List<Double> averageOfLevels(TreeNode root){
		List<Double> resultList = new ArrayList<>();
		List<Long> vals = new ArrayList<>();
		List<Integer> counts = new ArrayList<>();
		if(root==null)
			return null;
		else
			averageOfLevel(root,vals,counts,0);
			for(int i = 0; i< vals.size(); i++)
				resultList.add(i,(double)vals.get(i)/counts.get(i));
		return resultList;
	}
	public void averageOfLevel(TreeNode root, List<Long> vals,List<Integer> counts,int level){
		if(vals.size()<=level)
			vals.add(level,(long)root.val);
		else
			vals.set(level,vals.get(level)+root.val);
		if(counts.size()<=level)
			counts.add(level,1);
		else
			counts.set(level,counts.get(level)+1);
		level++;
		if(root.left!=null)
			averageOfLevel(root.left, vals, counts, level);
		if(root.right!=null)
			averageOfLevel(root.right, vals, counts, level);
	}
	@Test
	public void test01(){
		
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		for(double b :averageOfLevels02(root))
			System.out.println(b);
		
//		[2147483647,2147483647,2147483647]
		TreeNode root2 = new TreeNode(2147483647);
		root2.left = new TreeNode(2147483647);
		root2.right = new TreeNode(2147483647);
		for(double b :averageOfLevels02(root2))
			System.out.println(b);
	}
	/**********************************************/
	/**
	 * 优秀作品01
	 * BFS广度优先搜索
	 */
	public List<Double> averageOfLevels01(TreeNode root) {
	    List<Double> result = new ArrayList<>();
	    Queue<TreeNode> q = new LinkedList<>();
	    
	    if(root == null) return result;
	    q.add(root);
	    while(!q.isEmpty()) {
	        int n = q.size();
	        double sum = 0.0;
	        for(int i = 0; i < n; i++) {
	            TreeNode node = q.poll();
	            sum += node.val;
	            if(node.left != null) q.offer(node.left);
	            if(node.right != null) q.offer(node.right);
	        }
	        result.add(sum / n);
	    }
	    return result;
	}
	
    /**
     * 优秀作品02
     * DFS: a new node class make it more readable and professional
     */
    public List<Double> averageOfLevels02(TreeNode root) {
        List<Node> temp = new ArrayList<>();
        helper(root, temp, 0);
        List<Double> result = new LinkedList<>();
        for (int i = 0; i < temp.size(); i++) {
            result.add(temp.get(i).sum / temp.get(i).count);
        }
        return result;
    }
    class Node {
        double sum;
        int count;
        Node (double d, int c) {
            sum = d;
            count = c;
        }
    }
    public void helper(TreeNode root, List<Node> temp, int level) {
        if (root == null) return;
        if (level == temp.size()) {
            Node node = new Node((double)root.val, 1);
            temp.add(node);
        } else {
            temp.get(level).sum += root.val;
            temp.get(level).count++;
        }
        helper(root.left, temp, level + 1);
        helper(root.right, temp, level + 1);
    }
	
	
}
