package section_10_data_structures_trees;

public class Node<T> {
    public T value;
    public Node<T> left;
    public Node<T> right;


    public Node(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
