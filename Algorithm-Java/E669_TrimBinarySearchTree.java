package com.jack.leetcode.easy;

/**
Description
Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in [L, R] (R >= L). You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.

Example 1:
Input: 
    1
   / \
  0   2

  L = 1
  R = 2

Output: 
    1
      \
       2
Example 2:
Input: 
    3
   / \
  0   4
   \
    2
   /
  1

  L = 1
  R = 3

Output: 
      3
     / 
   2   
  /
 1
 * @author jiatg
 *
 */
public class A669_TrimBinarySearchTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(2);
		int L = 1, R = 2;
		TreeNode result = trimBST(root,L,R);
		TreeNode.traverse(result);
	}
	
    /**
     * Accepted：第2次提交通过，beats 84%.
     */
    public static TreeNode trimBST(TreeNode root, int L, int R) {
    	/*
    	 * 找到正确的根节点root
    	 */
    	while(root.val < L || root.val > R){
	    	if(root.val < L)
	    		root = root.right;
	    	if(root.val > R)
	    		root = root.left;
    	}	
    	/*
    	 * 去除root左子树所有小于L的节点
    	 */
    	TreeNode flag = root;
    	while(flag.left != null){
    		if(flag.left.val < L){
    			if(flag.left.right != null)
    				flag.left = flag.left.right;
    			else
    				flag.left = null;
    		}else
    			flag = flag.left;
    	}
    		
    	/*
    	 * 去除root右子树所有大于R的节点
    	 */
    	flag = root;
    	while(flag.right != null){
    		if(flag.right.val > R){
    			if(flag.right.left != null)
    				flag.right = flag.right.left;
    			else
    				flag.right = null;
    		}else
    			flag = flag.right;
    	}
        return root;
    }
}
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int val){
		this.val = val;
	}
	public static void traverse(TreeNode root){
		if(root != null)
			System.out.println(root.val);
		if(root.left != null)
			traverse(root.left);
		if(root.right != null)
			traverse(root.right);
	}
}
