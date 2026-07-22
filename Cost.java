import java.util.*;

public class Cost {
    public static int calculateTotalCost(int k, int n, int m, List<int[]> edges) {
        // Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        // BFS/DFS from node 0 to visit all nodes
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        
        int nonFunctionalCount = 0;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            
            // Check if node is divisible by M and not 0
            if (node != 0 && node % m == 0) {
                nonFunctionalCount++;
            }
            
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        
        // Count any remaining nodes that weren't reachable
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && i % m == 0) {
                nonFunctionalCount++;
            }
        }
        
        return nonFunctionalCount * k;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int edgeCount = scanner.nextInt();
        
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < edgeCount; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            edges.add(new int[]{u, v});
        }
        
        System.out.println(calculateTotalCost(k, n, m, edges));
        scanner.close();
    }
}