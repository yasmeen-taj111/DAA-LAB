import java.util.*;

class Solution {

    // function to print all subsets
    public static void findSubsets(int ind, int[] arr,
                                   int target,
                                   ArrayList<Integer> list) {

        // target achieved
        if (target == 0) {
            System.out.println(list);
            return;
        }

        // no elements left
        if (ind < 0) {
            return;
        }

        // take
        if (arr[ind] <= target) {

            list.add(arr[ind]);

            findSubsets(ind - 1,
                        arr,
                        target - arr[ind],
                        list);

            // backtrack
            list.remove(list.size() - 1);
        }

        // not take
        findSubsets(ind - 1,
                    arr,
                    target,
                    list);
    }

    public static boolean subsetSum(int[] arr, int k) {

        int n = arr.length;

        boolean[][] dp = new boolean[n][k + 1];

        // base case
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if (arr[0] <= k) {
            dp[0][arr[0]] = true;
        }

        // filling dp table
        for (int ind = 1; ind < n; ind++) {

            for (int target = 1; target <= k; target++) {

                boolean notTake = dp[ind - 1][target];

                boolean take = false;

                if (arr[ind] <= target) {
                    take = dp[ind - 1][target - arr[ind]];
                }

                dp[ind][target] = take || notTake;
            }
        }

        return dp[n - 1][k];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of elements:");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter target sum:");
        int k = sc.nextInt();

        long start = System.nanoTime();

        boolean ans = subsetSum(arr, k);

        long end = System.nanoTime();

        System.out.println("Subset sum exists: " + ans);

        if (ans) {

            System.out.println("Subsets are:");

            findSubsets(n - 1,
                        arr,
                        k,
                        new ArrayList<>());
        }

        double time = (end - start) / 1e6;

        System.out.println("Execution Time: " + time + " ms");

        System.out.println("Time Complexity: O(n * k)");

        sc.close();
    }
}
