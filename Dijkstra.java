import java.util.*;

class Solution {

    class Pair {
        int node, dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public void dijkstra(int[][] graph, int src, int n) {

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((x, y) -> x.dist - y.dist);

        int[] dist = new int[n];

        Arrays.fill(dist, (int)(1e9));

        dist[src] = 0;

        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {

            Pair it = pq.poll();

            int u = it.node;
            int dis = it.dist;

            for (int v = 0; v < n; v++) {

                // edge exists
                if (graph[u][v] != 0) {

                    // relaxation
                    if (dis + graph[u][v] < dist[v]) {

                        dist[v] = dis + graph[u][v];

                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        // printing answer
        System.out.println("Shortest distances from source " + src);

        for (int i = 0; i < n; i++) {
            System.out.println(src + " -> " + i + " = " + dist[i]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of vertices:");
        int n = sc.nextInt();

        int[][] graph = new int[n][n];

        System.out.println("Enter weighted adjacency matrix:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter source vertex:");
        int src = sc.nextInt();

        Solution obj = new Solution();

        obj.dijkstra(graph, src, n);

        sc.close();
    }
}
