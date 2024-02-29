package section_10_data_structures_trees;

public class BinarySearchTree {

    public Node<Integer> root;

    BinarySearchTree(Integer value) {
        root = new Node(value);
    }

    BinarySearchTree() {
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(9);
        bst.insert(4);
        bst.insert(20);
        bst.insert(1);
        bst.insert(6);
        bst.insert(15);
        bst.insert(99);

//        System.out.println(bst);

        bst.insert(16);
        bst.insert(17);
        bst.insert(18);
        bst.insert(14);
        bst.insert(13);


        System.out.println(bst);

        bst.remove(18);

        System.out.println(bst);

        bst.remove(13);

        System.out.println(bst);

        bst.remove(15);

        System.out.println(bst);
        System.out.println(bst.lookup(13));

    }

    public void insert(Integer value) {

        var newNode = new Node<>(value);

        if (root == null) {
            root = newNode;
        } else {
            var node = root;

            while (node != null) {
                if (newNode.value >= node.value) {
                    if (node.right != null) {
                        node = node.right;
                    } else {
                        node.right = newNode;
                        node = null;
                    }
                } else {
                    if (node.left != null) {
                        node = node.left;
                    } else {
                        node.left = newNode;
                        node = null;
                    }
                }
            }

        }


    }


    public Node<Integer> lookup(Integer value) {
        var node = root;

        while (node != null) {
            if (value.equals(node.value)) {
                return node;
            } else if (value < node.value) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        return null;
    }

    public void remove(Integer value) {
        root = removeRecursively(root, value);
    }

    private Node<Integer> removeRecursively(Node<Integer> node, Integer value) {
        if (node == null) {
            return null;
        } else if (value > node.value) {
            node.right = removeRecursively(node.right, value);
        } else if (value < node.value) {
            node.left = removeRecursively(node.left, value);
        } else {
            // Node with the key found

            // Case 1: Node with one child or no child
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            // Case 3: Node with two child
            // Find the in-order successor (smallest node in the right subtree)
            node.value = findMin(node.right, node.value);

            // Remove the in-order successor
            node.right = removeRecursively(node.right, node.value);
        }

        return node;
    }

    private Integer findMin(Node<Integer> node, Integer value) {
        // Helper function to find the smallest node in a subtree
        while (node.left != null) {
            node = node.left;

        }

        return node.value;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        toStringHelper(root, result, 0);
        return result.toString();
    }

    private void toStringHelper(Node<Integer> node, StringBuilder result, int depth) {
        if (node != null) {
            // Print right subtree
            toStringHelper(node.right, result, depth + 1);

            // Indent based on the depth
            for (int i = 0; i < depth; i++) {
                result.append("     ");
            }

            // Print the value of the node
            result.append(node.value).append("\n");

            // Print left subtree
            toStringHelper(node.left, result, depth + 1);
        }
    }

}
