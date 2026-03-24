import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

public class BST {
    static Node root = null;

    // Insert
    static Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }

        if (val < root.data) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    // Find minimum
    static Node findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // Delete
    static Node deleteNode(Node root, int val) {
        if (root == null) {
            System.out.println("Element not found");
            return root;
        }

        if (val < root.data) {
            root.left = deleteNode(root.left, val);
        } else if (val > root.data) {
            root.right = deleteNode(root.right, val);
        } else {
            // Case 1: No child
            if (root.left == null && root.right == null) {
                return null;
            }
            // Case 2: One child
            else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Case 3: Two children
            Node temp = findMin(root.right);
            root.data = temp.data;
            root.right = deleteNode(root.right, temp.data);
        }

        return root;
    }

    // Inorder traversal
    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch, val;

        while (true) {
            System.out.println("\n1.Insert\n2.Delete\n3.Display(Inorder)\n4.Exit");
            System.out.print("Enter choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter value: ");
                    val = sc.nextInt();
                    root = insert(root, val);
                    System.out.println("Inserted Successfully!");
                    break;

                case 2:
                    System.out.print("Enter value to delete: ");
                    val = sc.nextInt();
                    root = deleteNode(root, val);
                    break;

                case 3:
                    System.out.print("Inorder Traversal: ");
                    inorder(root);
                    System.out.println();
                    break;

                case 4:
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
