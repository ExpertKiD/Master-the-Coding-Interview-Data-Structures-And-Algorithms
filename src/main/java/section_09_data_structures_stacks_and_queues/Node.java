package section_09_data_structures_stacks_and_queues;

public class Node<T> {
    public Node<T> next;
    public T value;

    public Node(T value) {
        this.next = null;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +

                "value=" + value + ", " +
                "next=" + next +
                '}';
    }
}
