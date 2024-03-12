class Main {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(9);

        TreeNode p = root.left;
        TreeNode q = root.left.left;

        System.out.println(lowestCommonAncestor(root, p, q).val);
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        //if p and q are less than the root, run the method again but with the new root as the right child
        if (p.val < root.val && q.val < root.val){
            lowestCommonAncestor(root.right, p, q);
        }
        //if p and q are greater than the root, recursive with new root as left child.
        else if (p.val > root.val && q.val > root.val) {
            lowestCommonAncestor(root.left, p, q);
        }
        //if one of the two nodes is less and the other greater than root, the current node is the LCA
        else {
            return root;
        }
        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    }
