package section_08_data_structures_linked_list;


public class DoublyLinkedList<T> {


    public ListNode<T> head;
    public ListNode<T> tail;
    public int length;


    DoublyLinkedList(T value) {
        ListNode<T> node = new ListNode<T>(value);

        head = tail = node;

        length++;
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> linkedList = new DoublyLinkedList<Integer>(10);

        linkedList.append(5);
        linkedList.append(16);

        System.out.println(linkedList);

        linkedList.prepend(1);

        System.out.println(linkedList);

        linkedList.insert(2, 99);
        linkedList.insert(20, 88);

        System.out.println(linkedList);

        linkedList.remove(2);
        linkedList.remove(2);

        System.out.println(linkedList);
    }

    public void append(T value) {
        ListNode<T> node = new ListNode<T>(value);

        if (head == null) {
            head = tail = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;

        }
        length++;
    }

    public void prepend(T value) {
        ListNode<T> node = new ListNode<>(value);

        if (head == null) {
            head = tail = node;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
        }

        length++;
    }

    private ListNode<T> traverseToIndex(int index) {
        int counter = 0;

        var currentNode = head;
        while (counter != index) {
            currentNode = currentNode.next;
            counter++;
        }

        return currentNode;


    }

    public void insert(int index, T value) {

        ListNode<T> nodeToInsert = new ListNode<>(value);

        if (index <= 0) {
            prepend(value);
        } else if (index >= length) {
            append(value);
        } else {
            int currentIndex = 0;


            var leader = traverseToIndex(index - 1);
            var follower = leader.next;

            leader.next = nodeToInsert;
            nodeToInsert.prev = leader;

            nodeToInsert.next = follower;
            follower.prev = nodeToInsert;
        }


        length++;


    }

    public void remove(int index) {
        if (head == null) {
            return;
        } else if (index <= 0 || length == 1) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }

        } else if (index >= length - 1) {
            ListNode<T> leadNode = traverseToIndex(
                    length - 2
            );

            leadNode.next.prev = null;
            leadNode.next = null;
        } else {
            ListNode<T> leadNode = traverseToIndex(index - 1);
            ListNode<T> unwantedNode = leadNode.next;
            ListNode<T> tailNode = unwantedNode.next;

            leadNode.next = tailNode;
            tailNode.prev = leadNode;

            unwantedNode.prev = unwantedNode.next = null;

        }

        if (length != 0) {
            length--;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("DoublyLinkedList {");
        ListNode<T> current = head;

        while (current != null) {
            result.append(current.value);
            if (current.next != null) {
                result.append(" <-> ");
            }
            current = current.next;
        }

        result.append("} ");

        result.append("Length: ").append(length);

        return result.toString();
    }
}
