import java.util.*;

class Edge {

    int src;
    int dest;
    int weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

class Solution {

    static int parent[];

    // Find Parent
    static int find(int x) {

        if (parent[x] == x)
            return x;

        return parent[x] = find(parent[x]);
    }

    // Union
    static void union(int u, int v) {

        int pu = find(u);
        int pv = find(v);

        parent[pu] = pv;
    }

    static int kruskal(int V, int[][] graph) {

        PriorityQueue<Edge> pq =
                new PriorityQueue<Edge>((x, y) -> x.weight - y.weight);

        // Store all edges in PQ
        for (int i = 0; i < V; i++) {

            for (int j = i + 1; j < V; j++) {

                if (graph[i][j] != 0) {

                    pq.add(new Edge(i, j, graph[i][j]));
                }
            }
        }

        // Parent initialization
        parent = new int[V];

        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }

        int sum = 0;

        System.out.println("Edges in MST:");

        while (pq.size() > 0) {

            Edge e = pq.remove();

            int u = e.src;
            int v = e.dest;
            int wt = e.weight;

            // If cycle not formed
            if (find(u) != find(v)) {

                union(u, v);

                System.out.println(u + " -> " + v + " = " + wt);

                sum += wt;
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

        int ans = kruskal(V, graph);

        System.out.println("Minimum Cost = " + ans);

        sc.close();
    }
}
