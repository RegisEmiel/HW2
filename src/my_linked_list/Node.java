package my_linked_list;

public class Node<E> {
    E data;
    Node<E> next;
    Node<E> prev;

    Node(E data) {
        this(data,null, null);
    }

    Node(E data, Node<E> prev, Node<E> next) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}
