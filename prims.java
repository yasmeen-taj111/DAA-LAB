import java.util.Scanner;

public class prims {
    public static void main(String[] args) {
        int w[][] = new int[10][10];
        int n, i, j, s, k = 0;
        int min;
        int sum = 0;
        int u = 0, v = 0;
        int flag = 0;
        int sol[] = new int[10];

        System.out.println("Enter the number of vertices");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        // Initialize solution array
        for (i = 1; i <= n; i++)
            sol[i] = 0;

        System.out.println("Enter the weighted graph");
        for (i = 1; i <= n; i++)
            for (j = 1; j <= n; j++)
                w[i][j] = sc.nextInt();

        System.out.println("Enter the source vertex");
        s = sc.nextInt();

        sol[s] = 1; // mark source as visited
        k = 1;

        while (k <= n - 1) {
            min = Integer.MAX_VALUE;
            u = -1;
            v = -1;

            for (i = 1; i <= n; i++) {
                for (j = 1; j <= n; j++) {
                    if (sol[i] == 1 && sol[j] == 0) {
                        if (i != j && w[i][j] < min) {
                            min = w[i][j];
                            u = i;
                            v = j;
                        }
                    }
                }
            }

            // If no edge found → graph disconnected
            if (v == -1) {
                break;
            }

            sol[v] = 1;
            sum = sum + min;
            k++;

            System.out.println(u + "->" + v + "=" + min);
        }

        // Check if all vertices are included
        for (i = 1; i <= n; i++) {
            if (sol[i] == 0) {
                flag = 1;
            }
        }

        if (flag == 1)
            System.out.println("No spanning tree");
        else
            System.out.println("The cost of minimum spanning tree is " + sum);

        sc.close();
    }
}
