import java.util.Scanner;

public class HorspoolStringMatching {

    // Function to create shift table
    public static int[] shiftTable(String pattern) {
        int m = pattern.length();
        int[] table = new int[256];

        // Initialize all values with pattern length
        for (int i = 0; i < 256; i++) {
            table[i] = m;
        }

        // Fill based on pattern
        for (int i = 0; i < m - 1; i++) {
            table[pattern.charAt(i)] = m - 1 - i;
        }

        return table;
    }

    // Horspool Search Function
    public static int horspoolSearch(String text, String pattern) {
        int m = pattern.length();
        int n = text.length();

        int[] table = shiftTable(pattern);

        int i = m - 1;

        while (i < n) {
            int k = 0;

            // Compare from right to left
            while (k < m && pattern.charAt(m - 1 - k) == text.charAt(i - k)) {
                k++;
            }

            // If full match found
            if (k == m) {
                return i - m + 1;
            } else {
                i += table[text.charAt(i)];
            }
        }

        return -1; // Not found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        System.out.print("Enter pattern: ");
        String pattern = scanner.nextLine();

        long start = System.nanoTime();

        int index = horspoolSearch(text, pattern);

        long end = System.nanoTime();

        if (index != -1) {
            System.out.println("Pattern found at index: " + index);
        } else {
            System.out.println("Pattern not found");
        }

        System.out.println("Execution time: " + (end - start) / 1e6 + " ms");

        scanner.close();
    }
}
