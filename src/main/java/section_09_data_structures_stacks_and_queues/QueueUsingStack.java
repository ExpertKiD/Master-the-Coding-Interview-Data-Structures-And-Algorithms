package section_09_data_structures_stacks_and_queues;

public class QueueUsingStack<T> {

    public Stack<T> enqueueStack, dequeueStack;

    public int size() {
        return dequeueStack.size + enqueueStack.size;
    }


    QueueUsingStack() {
        enqueueStack = new Stack<T>();
        dequeueStack = new Stack<T>();
    }

    public T peek() {
        if (dequeueStack.size == 0) {
            transferElements();
        }

        if (dequeueStack.size == 0) {
            return null;
        } else {
            return dequeueStack.peek().value;
        }
    }

    public void enqueue(T value) {
        enqueueStack.push(value);
    }

    public T dequeue() {
        if (dequeueStack.size == 0) {
            transferElements();
        }

        if (dequeueStack.size != 0) {
            var node = dequeueStack.pop();
            return node.value;
        }


        return null;
    }


    private void transferElements() {
        if (enqueueStack.size == 0) {
            return;
        }

        while (enqueueStack.size != 0) {
            dequeueStack.push(enqueueStack.pop().value);
        }
    }

    @Override
    public String toString() {
        return "QueueUsingStack{" +
                "enqueueStack=" + enqueueStack +
                ", dequeueStack=" + dequeueStack +
                '}';
    }

    public static void main(String[] args) {
        QueueUsingStack<String> queue = new QueueUsingStack<>();

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
