package com.jack.leetcode.easy;

import org.junit.Test;

/**
# Description
	Given two binary trees and imagine that when you put one of them to cover the other
	, some nodes of the two trees are overlapped while the others are not.
	
	You need to merge them into a new binary tree. The merge rule is 
	that if two nodes overlap, then sum node values up as the new value of the merged node. 
	Otherwise, the NOT null node will be used as the node of new tree.

# Example 1:
	Input: 
		Tree 1                     Tree 2                  
	          1                         2                             
	         / \                       / \                            
	        3   2                     1   3                        
	       /                           \   \                      
	      5                             4   7                  
	Output: 
	Merged tree:
		     3
		    / \
		   4   5
		  / \   \ 
		 5   4   7

# Note: The merging process must start from the root nodes of both trees.
 
 * @author jiatg
 */
public class A617_MergeTwoBinaryTrees {

	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val){
			this.val = val;
		}
	}
	
	/**
	 * runtime:1%
	 * @param t1
	 * @param t2
	 * @return
	 */
	public TreeNode MergeTrees(TreeNode t1, TreeNode t2){
		TreeNode result = null;
		if(t1 != null || t2 != null)
			result = new TreeNode(0);
		merge(result,t1,t2);
		return result;
	}
	/**
	 * 递归调用一直处理不好。每次递归没有给left和right new对象，导致递归调用的result每次都是指向根节点。
	 * 最后，整个合并的过程计算是对的，结果只有一个根节点
	 * @param result
	 * @param t1
	 * @param t2
	 */
	public void merge(TreeNode result, TreeNode t1, TreeNode t2){
		if(t1 == null && t2 == null){
			result = null;
		}else if(t1 == null && t2 != null){
			result.val = t2.val;
			if(t2.left!=null)
				result.left = new TreeNode(0);
			merge(result.left,null,t2.left);
			if(t2.right!=null)
				result.right = new TreeNode(0);
			merge(result.right,null,t2.right);
		}else if(t1 != null && t2 == null){
			result.val = t1.val;
			if(t1.left != null)
				result.left = new TreeNode(0);
			merge(result.left,t1.left,null);
			if(t1.right != null)
				result.right = new TreeNode(0);
			merge(result.right,t1.right,null);
		}else if(t1 != null && t2 != null){
			result.val = t1.val + t2.val;
			if(t1.left != null || t2.left != null)
				result.left = new TreeNode(0);
			merge(result.left,t1.left,t2.left);
			if(t1.right != null || t2.right != null)
				result.right = new TreeNode(0);
			merge(result.right,t1.right,t2.right);
		}
	}
	
	@Test
	public void test01(){
		TreeNode t1 = new TreeNode(1);
		//System.out.println("t1 val:"+t1.val);
		t1.left = new TreeNode(3);
		t1.right = new TreeNode(2);
		t1.left.left = new TreeNode(5);
		TreeNode t2 = new TreeNode(2);
		t2.left = new TreeNode(1);
		t2.right = new TreeNode(3);
		t2.left.right = new TreeNode(4);
		t2.right.right = new TreeNode(7);
		
		
		
		System.out.println("traverse result:");
		traverse(MergeTrees(t1,t2));
		System.out.println("---------------");
		
		TreeNode t3 = null; TreeNode t4 = null;
		
		System.out.println("traverse result:");
		traverse(MergeTrees(t3, t4));
		System.out.println("---------------");
		
		TreeNode t5 = new TreeNode(1);
		t5.left = new TreeNode(2);
		t5.left.left = new TreeNode(3);
		TreeNode t6 = new TreeNode(1);
		t6.right = new TreeNode(2);
		t6.right.right = new TreeNode(3);
		
		System.out.println("traverse result:");
		traverse(MergeTrees(t5, t6));
		System.out.println("---------------");
	}
	
	
	/**
	 * 二叉树的中序遍历
	 * @param root
	 */
	public void traverse(TreeNode root){
		if(root == null){
			//System.out.println("null");
			return ;
		}
		System.out.println(root.val);
		
		traverse(root.left);
		traverse(root.right);
	}
	/***********************************************************/
	/**
	 * 优秀作品1：
	 */
	public TreeNode mergeTrees_01(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        
        int val = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
        TreeNode newNode = new TreeNode(val);
        
        newNode.left = mergeTrees_01(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        newNode.right = mergeTrees_01(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
        
        return newNode;
    }
}
