package l33tc0de;

public class DeleteNodeInBST {
	/*public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            TreeNode rightguy = root.right;
            TreeNode leftguy = root.left;
            TreeNode ml = root.left;
            if (leftguy == null){
                return rightguy;
            }
            while (ml.right != null) {
                ml = ml.right;
            }
            ml.right = rightguy;
            return leftguy;
        }
        if (root.val > key){
            root.left = deleteNode(root.left, key);
        }
        else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }*/
}
