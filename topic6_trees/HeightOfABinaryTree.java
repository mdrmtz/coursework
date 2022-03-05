/*
  class Node
    int data;
    Node left;
    Node right;
*/
class Node {
    int data;
    Node left;
    Node right;
}

public class HeightOfABinaryTree {
    static int height(Node root) {
        if (root == null || root.right == null && root.left == null) return 0;
        return Math.max(height(root.right), height(root.left)) + 1;
    }
}
