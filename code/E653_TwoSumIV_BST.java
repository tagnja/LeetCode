import java.util.Stack;
public class E653_TwoSumIV_BST{
    
    public static void main(String[] args){
        TreeNode root = new TreeNode(5); 
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        

        E653_TwoSumIV_BST test = new E653_TwoSumIV_BST();
        System.out.println(test.findTarget(root, Integer.parseInt(args[0])));
        TreeNode root2 = new TreeNode(1);
        System.out.println(test.findTarget(root2, 2)); 

        TreeNode root3 = new TreeNode(2);
        root3.left = new TreeNode(1);
        root3.right = new TreeNode(3);
        System.out.println(test.findTarget(root3, 4)); 

    }
    public boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while(!stack.empty() || cur != null){
            while(cur != null){
//                System.out.println("cur val:"+cur.val);
                if(cur.val != k/2 && find(root, k - cur.val))
                    return true;
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.peek();
            if(top.right != null){
//                System.out.println("cur val:"+top.right.val);
                if(top.right.val != k/2 && find(root, k - top.right.val))
                    return true;
            }
            cur = top.right;
            stack.pop();
        }
        return false;
    }
    public boolean find(TreeNode root, int num){
//        if(root != null)
//            System.out.println("cur val:"+root.val+", look for:"+num);
        if(num == root.val)
            return true;
        if(num < root.val){
            if(root.left != null)
                return find(root.left, num);
        }
        if(num > root.val){
            if(root.right != null)
                return find(root.right, num);
        }
        return false;
    }
} 
