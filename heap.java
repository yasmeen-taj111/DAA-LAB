import java.util.*;

public class HeapSortSimple {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] A = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        System.out.println("Original Array: " + Arrays.toString(A));

        long start = System.nanoTime();

        heapSort(A);

        long end = System.nanoTime();

        System.out.println("Sorted Array: " + Arrays.toString(A));
        System.out.println("Time taken: " + (end - start) + " ns");
    }

    // Heap Sort Function
    static void heapSort(int A[]) {
        int n = A.length;

        // STEP 1: Build Max Heap
        for (int i = n/2 - 1; i >= 0; i--) {
            heapify(A, n, i);
        }

        // STEP 2: Delete one by one
        for (int i = n - 1; i > 0; i--) {
            // Swap root with last
            int temp = A[0];
            A[0] = A[i];
            A[i] = temp;

            // Heapify reduced heap
            heapify(A, i, 0);
        }
    }

    // Heapify Function (Fix heap)
    static void heapify(int A[], int n, int i) {
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        // Check left child
        if (left < n && A[left] > A[largest]) {
            largest = left;
        }

        // Check right child
        if (right < n && A[right] > A[largest]) {
            largest = right;
        }

        // Swap if needed
        if (largest != i) {
            int temp = A[i];
            A[i] = A[largest];
            A[largest] = temp;

            // Recursively fix heap
            heapify(A, n, largest);
        }
    }
}
