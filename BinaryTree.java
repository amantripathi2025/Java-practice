import java.util.*;
import java.io.*;

class BinaryTree {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        line = line.substring(1, line.length() - 1); // strip [ and ]
        String[] parts = line.split(",");
        int n = parts.length;
        int[] vals = new int[n];
        for (int i = 0; i < n; i++) vals[i] = Integer.parseInt(parts[i].trim());

        TreeNode root = buildTree(vals, 0, n);
        boolean hasOne = containsOne(root);
        if (!hasOne) root = null;

        List<String> output = new ArrayList<>();
        serialize(root, output);

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < output.size(); i++) {
            sb.append(output.get(i));
            if (i < output.size() - 1) sb.append(", ");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    // Build complete binary tree from array representation
    static TreeNode buildTree(int[] vals, int index, int n) {
        if (index >= n) return null;
        TreeNode node = new TreeNode(vals[index]);
        node.left = buildTree(vals, 2 * index + 1, n);
        node.right = buildTree(vals, 2 * index + 2, n);
        return node;
    }

    // Standard pruning: returns true if subtree contains a 1, and prunes children that don't
    static boolean containsOne(TreeNode node) {
        if (node == null) return false;
        boolean left = containsOne(node.left);
        boolean right = containsOne(node.right);
        if (!left) node.left = null;
        if (!right) node.right = null;
        return node.val == 1 || left || right;
    }

    // BFS serialization: only expand non-null children
    static void serialize(TreeNode root, List<String> output) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        output.add(String.valueOf(root.val));

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left != null) {
                output.add(String.valueOf(node.left.val));
                queue.offer(node.left);
            } else {
                output.add("null");
            }

            if (node.right != null) {
                output.add(String.valueOf(node.right.val));
                queue.offer(node.right);
            } else {
                output.add("null");
            }
        }
    }
}