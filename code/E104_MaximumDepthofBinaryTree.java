package com.jack.leetcode.easy;

import org.junit.Test;

public class A104_MaximumDepthofBinaryTree {

	/**
	 * runtime: 15%
	 * @param root
	 * @return
	 */
	public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int[] nums = new int[1];
        nums[0] = 0;
        findHelp(root,0,nums);
        return nums[0];
    }
    public void findHelp(TreeNode root, int level, int[] nums){
        if(root != null){
            level++;
            if(level>nums[0])
            	nums[0] = level;
            //System.out.println("level:"+level);
            findHelp(root.left,level,nums);
            findHelp(root.right,level,nums);
        }
        
    }
    class TreeNode{
    	int val;
    	TreeNode left;
    	TreeNode right;
    	public TreeNode(int val){
    		this.val = val;
    	}
    }
    @Test
    public void test01(){
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	root.right = new TreeNode(3);
    	root.left.left = new TreeNode(4);
    	root.left.right = new TreeNode(5);
    	
    	TreeNode root2 = new TreeNode(1);
    	root2.left = new TreeNode(2);
    	root2.right = new TreeNode(3);
    	root2.right.left = new TreeNode(4);
    	root2.right.right = new TreeNode(5);
    	System.out.println("result1:"+maxDepth(root));
    	System.out.println("result2:"+maxDepth(root2));
    }
    
    /*******************************************/
    /**
     * 优秀作品01
     */
    public int maxDepth01(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
