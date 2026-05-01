import java.util.*;
//0-based

class Solution {

    // DFS function
    public static void dfs(int node, boolean vis[],
                           ArrayList<ArrayList<Integer>> adj) {

        // mark current node as visited
        vis[node] = true;

        // visit all neighbours
        for (Integer it : adj.get(node)) {

            // if neighbour not visited
            if (vis[it] == false) {
                dfs(it, vis, adj);
            }
        }
    }

    // Function to check graph connected or not
    public static boolean isConnected(int V,
                        ArrayList<ArrayList<Integer>> adj) {

        // visited array
        boolean vis[] = new boolean[V];

        // start DFS from node 0
        dfs(0, vis, adj);

        // check all vertices visited or not
        for (int i = 0; i < V; i++) {

            if (vis[i] == false) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // input vertices and edges
        System.out.println("Enter number of vertices:");
        int V = sc.nextInt();

        System.out.println("Enter number of edges:");
        int E = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj =
                new ArrayList<>();

        // create adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // input edges
        System.out.println("Enter edges:");

        for (int i = 0; i < E; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();

            // undirected graph
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // check connectivity
        if (isConnected(V, adj)) {
            System.out.println("Graph is Connected");
        } else {
            System.out.println("Graph is Not Connected");
        }
    }
}
