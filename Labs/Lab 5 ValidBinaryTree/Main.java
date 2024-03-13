import com.sun.source.tree.Tree;

public class Main {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(3);
        root1.left.left = new TreeNode(1);
        root1.right = new TreeNode(8);
        root1.right.left = new TreeNode(5);
        root1.right.right = new TreeNode(9);
        System.out.println(isValidBST(root1));
        
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right = new TreeNode(8);
        root2.right.left = new TreeNode(5);
        root2.right.right = new TreeNode(6);
        System.out.println(isValidBST(root2));
    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left == null) {
            //do nothing
        }
        else if(root.left.val > root.val) {
            return false;
        }

        if(root.right == null) {
            //do nothing
        }
        else if (root.right.val < root.val){
            return false;
        }

        return (isValidBST(root.left) && isValidBST(root.right));
    }

    public static class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;

        TreeNode() {}

        TreeNode(int val) { this.val = val; }

        TreeNode(int val, TreeNode left, TreeNode right) {

            this.val = val;

            this.left = left;

            this.right = right;

        }

    }
}
