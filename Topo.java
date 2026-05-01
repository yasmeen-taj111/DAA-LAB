import java.util.*;

public class TopologicalSort {

    // DFS function
    static void dfs(int node, int vis[], Stack<Integer> st,
                    ArrayList<ArrayList<Integer>> adj) {

        vis[node] = 1;

        // Visit all neighbors
        for (int it : adj.get(node)) {
            if (vis[it] == 0) {
                dfs(it, vis, st, adj);
            }
        }

        // Push after visiting all neighbors
        st.push(node);
    }

    // Topological Sort function
    static void topoSort(int V, ArrayList<ArrayList<Integer>> adj) {

        int vis[] = new int[V];
        Stack<Integer> st = new Stack<>();

        // Call DFS for all vertices
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, st, adj);
            }
        }

        // Print answer
        System.out.println("Topological Order:");

        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Input adjacency matrix
        System.out.println("Enter adjacency matrix:");

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {

                int x = sc.nextInt();

                if (x == 1) {
                    adj.get(i).add(j);
                }
            }
        }

        topoSort(V, adj);

        sc.close();
    }
}
