package section_09_data_structures_stacks_and_queues;

import section_08_data_structures_linked_list.ListNode;

public class Stack<T> {

    public Node<T> top;
    public Node<T> bottom;

    public int size;

    public Stack() {
        top = bottom = null;
        size = 0;
    }

    public Node<T> peek() {
        return top;
    }

    public void push(T value) {
        Node<T> node = new Node<>(value);

        if (top == null) {
            top = bottom = node;
        } else {
            node.next = top;
            top = node;

        }

        size++;
    }

    public Node<T> pop() {
        Node<T> holdingPointer;
        holdingPointer = top;

        if (size <= 1) {
            top = bottom = null;
            size = 0;
        } else {

            top = top.next;
            size--;
        }

        return holdingPointer;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Stack:\n");

        Node<T> current = top;

        result.append("+---+\n");

        while (current != null) {

            result.append(current.value).append("\n");

            current = current.next;
        }
        result.append("+---+\n");

        result.append("Size: ").append(size);

        return result.toString();
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        System.out.println(stack.peek());

        System.out.println(stack);

        stack.push("google");
        stack.push("udemy");
        stack.push("discord");

        System.out.println(stack);

        System.out.println(stack.peek());

        stack.pop();
        stack.pop();

        System.out.println(stack);

        stack.pop();

        System.out.println(stack);
    }


}
