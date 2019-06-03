import java.util.Stack;

public class E538_ConvertBSTtoGreaterTree{
    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);
        TreeNode root2 = root;
        traverse(new E538_ConvertBSTtoGreaterTree().convertBST(root));
        traverse(new E538_ConvertBSTtoGreaterTree().convertBST2(root2));
    }
    /**
      * Method 1: Recursion
      */
    public TreeNode convertBST(TreeNode root){
        convert(root);
        return root;
    }
    int previous = 0;
    public void convert(TreeNode root){
        if(root == null)
            return;
        convert(root.right);
        root.val += previous;
        previous = root.val;
        convert(root.left);
    }

    /**
      * Method 2: Non-Recursion
      */
    public TreeNode convertBST2(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        TreeNode prev = null;
        while(!stack.empty() || cur != null){
            while(cur != null){
                stack.push(cur);
                cur = cur.right;
            }
      
            TreeNode top = stack.peek();
            if(prev == null){
                prev = new TreeNode(0);
            }
            top.val += prev.val;
//            System.out.println("top val:"+top.val);
            prev = top;
            cur = top.left;
            stack.pop();
        }
        return root;
    }

    /**
      * traverse tree
      */
    public static void traverse(TreeNode root){
        if(root == null)
            return;
        System.out.println(root.val);
        traverse(root.left);
        traverse(root.right);
    }
}
