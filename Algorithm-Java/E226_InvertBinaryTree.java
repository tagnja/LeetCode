package com.jack.leetcode.easy;

import org.junit.Test;

public class A226_InvertBinaryTree {

	public TreeNode invertTree(TreeNode root) {
		if(root == null)
			return null;
		invertHelper(root);
		return root;
    }
	public void invertHelper(TreeNode root){
		if(root.left == null && root.right == null)
			return ;
		TreeNode temp = new TreeNode(0);
		temp = root.left;
		root.left = root.right;
		root.right = temp;
		if(root.left != null)
		    invertHelper(root.left);
        if(root.right != null)
		    invertHelper(root.right);
	}
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val){
			this.val = val;
		}
	}
	public void traverse(TreeNode root){
		if(root == null)
			return ;
		System.out.println(root.val);
		traverse(root.left);
		traverse(root.right);
	}
	@Test
	public void test01(){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		traverse(root);
		invertTree(root);
		traverse(root);
	}
}
