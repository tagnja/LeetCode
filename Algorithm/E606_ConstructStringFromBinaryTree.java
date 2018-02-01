
public class E606_ConstructStringFromBinaryTree{

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x; }
    }
    public static void main(String[] args){
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.left.left = new TreeNode(4);
        System.out.println(tree2str(t));
    }
    public static String tree2str(TreeNode t){
        if(t == null)
            return "";
        String s1 = t.val+"";
        
        if(t.left == null && t.right != null)
            s1 = s1+ "()("+tree2str(t.right)+")";
        else if(t.left != null && t.right == null)
            s1 = s1+ "("+tree2str(t.left)+")";
        else if(t.left != null && t.right != null)
            s1 = s1 + "("+tree2str(t.left)+")("+tree2str(t.right)+")";
        return s1;
    }
}
