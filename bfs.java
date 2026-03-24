import java.util.*;

public class BFSDirectedGraph {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int v = sc.nextInt();

        int[][] adj = new int[v][v];

        System.out.println("Enter adjacency matrix:");
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                adj[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter starting vertex: ");
        int start = sc.nextInt();

        System.out.println("BFS Traversal:");
        bfs(adj, start, v);

        sc.close();
    }

    static void bfs(int[][] adj, int start, int v) {

        boolean[] visited = new boolean[v];
        Queue<Integer> q = new LinkedList<>();

        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {

            int node = q.poll();
            System.out.print(node + " ");

            for (int i = 0; i < v; i++) {
               
                if (adj[node][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
