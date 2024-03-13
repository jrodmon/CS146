public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println(root.val);
        System.out.println(root.left.val + " " + root.right.val);
        System.out.println(root.left.left.val + " " + root.left.right.val + " "
                + root.right.left.val + " " + root.right.right.val);
        System.out.println("becomes");

        TreeNode invertedTree = invertTree(root);
        System.out.println(invertedTree.val);
        System.out.println(invertedTree.left.val + " " + invertedTree.right.val);
        System.out.println(invertedTree.left.left.val + " " + invertedTree.left.right.val + " "
                            + invertedTree.right.left.val + " " + invertedTree.right.right.val);
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null ) {
            return null;
        }
        TreeNode temp = new TreeNode();
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);

        return root;
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
