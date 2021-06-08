package junechal;

public class ConstructFromPreorderandInorder {
	Map<Integer, Integer> in; // value to its index in inorder
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        in = new HashMap<>();
        for (int i=0; i<inorder.length; i++) {
            in.put(inorder[i],i);
        }
        TreeNode overallroot = new TreeNode(preorder[0]);
        for (int i=1; i<preorder.length; i++) {
            TreeNode t = overallroot;
            boolean moved = true;
            while (moved) {
                moved = false;
                if (in.get(preorder[i]) < in.get(t.val) && t.left != null) {
                    t = t.left;
                    moved = true;
                }
                else if (t.right != null) {
                    t = t.right;
                    moved = true;
                }
            }
            if (in.get(preorder[i]) < in.get(t.val)) {
                t.left = new TreeNode(preorder[i]);
            }
            else {
                t.right = new TreeNode(preorder[i]);
            }
        }
        return overallroot;
    }
}
