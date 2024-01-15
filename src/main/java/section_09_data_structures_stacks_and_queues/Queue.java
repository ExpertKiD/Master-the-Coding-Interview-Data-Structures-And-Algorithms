package section_09_data_structures_stacks_and_queues;

public class Queue<T> {

    public Node<T> first;
    public Node<T> last;

    public int length;

    public Queue() {
        first = last = null;
        length = 0;
    }

    public Node<T> peek() {
        return first;
    }

    public void enqueue(T value) {
        Node<T> node = new Node<>(value);

        if (length == 0) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }

        length++;
    }

    public void dequeue() {
        if (length == 0) {
            return;
        } else if (length == 1) {
            first = last = null;
        } else {
            first = first.next;
        }

        length--;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Queue: ");

        Node<T> current = first;

        while (current != null) {

            result.append(current.value);

            if (current.next != null) {
                result.append(" <- ");
            }

            current = current.next;
        }


        result.append(" Length: ").append(length);

        return result.toString();
    }

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();

        System.out.println(queue.peek());

        System.out.println(queue);

        queue.enqueue("Joy");
        queue.enqueue("Matt");
        queue.enqueue("Pavel");
        queue.enqueue("Samir");

        System.out.println(queue);
        System.out.println(queue.peek());

        queue.dequeue();

        System.out.println(queue);

        queue.dequeue();
        queue.dequeue();

        System.out.println(queue);

        queue.dequeue();

        System.out.println(queue);
    }


}
