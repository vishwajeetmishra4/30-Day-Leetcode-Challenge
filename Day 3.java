// Day 3 of 30 Days Leetcode.

// Problem Number 1038: Binary Search Tree to Greater Search Tree

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}

class Solution {
  public TreeNode bstToGst(TreeNode root) {
    final int[] prefix = {0};

    reversedInorder(root, prefix);
    return root;
  }

  private void reversedInorder(TreeNode root, int[] prefix) {
    if (root == null)
      return;

    reversedInorder(root.right, prefix);

    root.val += prefix[0];
    prefix[0] = root.val;

    reversedInorder(root.left, prefix);
  }
}
