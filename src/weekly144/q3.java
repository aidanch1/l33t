package weekly144;

import java.util.*;

import javax.swing.tree.TreeNode;

class TreeNode {
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

public class q3 {
	public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		List<TreeNode> trees = new ArrayList<>();
		trees.add(root);
		Set<Integer> s = new HashSet<>();
		for (int i:to_delete) {
			s.add(i);
		}
		for (int j=0; j<trees.size(); j++) {
			deleteFrom(trees.get(j), s, trees);
		}
		for (int j=0; j<trees.size(); j++) {
			if (s.contains(trees.get(j).val)) {
				trees.remove(j);
				j--;
			}
		}
		return trees;
	}

	public TreeNode deleteFrom(TreeNode root, Set<Integer> toDel, List<TreeNode> trees) {
		if (root == null) {
			return null;
		}
		if (toDel.contains(root.val)) {
			if (root.left != null) {
				trees.add(root.left);
			}
			if (root.right != null) {
				trees.add(root.right);
			}
			return null;
		}
		else {
			root.left = deleteFrom(root.left, toDel, trees);
			root.right = deleteFrom(root.right, toDel, trees);
			return root;
		}
	}
}
