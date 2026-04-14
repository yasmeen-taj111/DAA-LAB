import java.util.Scanner;

public class kruskal {
    int parent[] = new int[10];

    int find(int m) {
        int p = m;
        while (parent[p] != 0)
            p = parent[p];
        return p;
    }

    void union(int i, int j) {
        if (i < j)
            parent[i] = j;
        else
            parent[j] = i;
    }

    void krkl(int[][] a, int n) {
        int u = 0, v = 0, min, k = 0, i, j, sum = 0;

        // Initialize parent array
        for (i = 1; i <= n; i++)
            parent[i] = 0;

        while (k < n - 1) {
            min = Integer.MAX_VALUE;
            u = -1;
            v = -1;

            // Find minimum edge
            for (i = 1; i <= n; i++) {
                for (j = 1; j <= n; j++) {
                    if (i != j && a[i][j] < min) {
                        min = a[i][j];
                        u = i;
                        v = j;
                    }
                }
            }

            // If no edge found → break
            if (u == -1 || v == -1)
                break;

            i = find(u);
            j = find(v);

            if (i != j) {
                union(i, j);
                System.out.println("(" + u + "," + v + ") = " + min);
                sum = sum + min;
                k++;
            }

            // Remove edge so it's not picked again
            a[u][v] = a[v][u] = Integer.MAX_VALUE;
        }

        if (k != n - 1)
            System.out.println("No spanning tree");
        else
            System.out.println("The cost of minimum spanning tree = " + sum);
    }

    public static void main(String[] args) {
        int a[][] = new int[10][10];
        int i, j;

        System.out.println("Enter the number of vertices of the graph");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println("Enter the weighted matrix");
        for (i = 1; i <= n; i++)
            for (j = 1; j <= n; j++)
                a[i][j] = sc.nextInt();

        kruskal k = new kruskal();
        k.krkl(a, n);

        sc.close();
    }
}
