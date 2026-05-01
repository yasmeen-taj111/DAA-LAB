import java.util.*;

class Pair {

    int node;
    int distance;
    int parent;

    Pair(int distance, int node, int parent) {
        this.node = node;
        this.distance = distance;
        this.parent = parent;
    }
}

class Solution {

    static int prims(int V, int[][] graph, int src) {

        PriorityQueue<Pair> pq =
                new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);

        int vis[] = new int[V];

        // {weight, node, parent}
        pq.add(new Pair(0, src, -1));

        int sum = 0;

        System.out.println("Edges in MST:");

        while (pq.size() > 0) {

            int wt = pq.peek().distance;
            int node = pq.peek().node;
            int parent = pq.peek().parent;

            pq.remove();

            // Skip if already visited
            if (vis[node] == 1)
                continue;

            vis[node] = 1;
            sum += wt;

            // Print MST edge
            if (parent != -1) {
                System.out.println(parent + " -> " + node + " = " + wt);
            }

            // Traverse neighbours
            for (int adjNode = 0; adjNode < V; adjNode++) {

                if (graph[node][adjNode] != 0 &&
                        vis[adjNode] == 0) {

                    pq.add(new Pair(graph[node][adjNode],
                            adjNode,
                            node));
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of vertices:");
        int V = sc.nextInt();

        int graph[][] = new int[V][V];

        System.out.println("Enter adjacency matrix:");

        for (int i = 0; i < V; i++) {

            for (int j = 0; j < V; j++) {

                graph[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter source vertex:");
        int src = sc.nextInt();

        int ans = prims(V, graph, src);

        System.out.println("Minimum Cost = " + ans);

        sc.close();
    }
}
