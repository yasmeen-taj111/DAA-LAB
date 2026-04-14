import java.util.Scanner;

public class DijkstraSimple {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n;
        System.out.println("Enter number of vertices:");
        n = sc.nextInt();

        int[][] graph = new int[n][n];

        System.out.println("Enter adjacency matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter source vertex:");
        int src = sc.nextInt();

        int[] dist = new int[n];     
        boolean[] visited = new boolean[n];

      
        for (int i = 0; i < n; i++) {
            dist[i] = 999;   // infinity
            visited[i] = false;
        }

        dist[src] = 0;

       
        for (int i = 0; i < n - 1; i++) {

            int min = 999, u = -1;

         
            for (int j = 0; j < n; j++) {
                if (!visited[j] && dist[j] < min) {
                    min = dist[j];
                    u = j;
                }
            }

            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (!visited[v] && graph[u][v] != 0 &&
                        dist[u] + graph[u][v] < dist[v]) {

                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }


        System.out.println("Shortest distances from source:");
        for (int i = 0; i < n; i++) {
            System.out.println("To " + i + " = " + dist[i]);
        }

        sc.close();
    }
}
