package section_08_data_structures_linked_list;

public class ListNode<T> {
    public ListNode<T> next;
    public T value;

    public ListNode( T value) {
        this.next = null;
        this.value = value;
    }
}
