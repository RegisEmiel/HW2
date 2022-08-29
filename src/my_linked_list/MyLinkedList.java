package my_linked_list;

import java.util.NoSuchElementException;

public class MyLinkedList<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    public MyLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    public void addFirst(E e) {
        Node<E> current = new Node<>(e,null, first);

        if (first == null) {
            last = current;
        }
        else {
            first.prev = current;
        }
        first = current;

        size++;
    }

    public void addLast(E e) {
        Node<E> current = new Node<>(e, last, null);

        if (last == null) {
            first = current;
        }
        else {
            last.next = current;
        }
        last = current;

        size++;
    }

    public void addBefore(E current, E newElement) {
        if (isEmpty())
            throw new NoSuchElementException("Element " + current.toString() + " not found");

        Node<E> temp = first;

        while (temp != null && !temp.data.equals(current))
            temp = temp.next;

        if (temp == null)
            throw new NoSuchElementException("Element " + current.toString() + " not found");

        Node<E> newNode = new Node<E>(newElement, temp.prev, temp);
        if (temp.prev != null)
            temp.prev.next = newNode;
        else
            first = newNode;
        temp.prev = newNode;

        size++;
    }

    public void addAfter(E current, E newElement) {
        if (isEmpty())
            throw new NoSuchElementException("Element " + current.toString() + " not found");

        Node<E> temp = first;

        // Looping through until found
        while (temp != null && !temp.data.equals(current))
            temp = temp.next;

        // If null, not found
        if (temp == null)
            throw new NoSuchElementException("Element " + current.toString() + " not found");

        // Not null, value found
        Node<E> newNode = new Node<E>(newElement, temp, temp.next);
        if (temp.next != null)
            temp.next.prev = newNode;
        temp.next = newNode;

        size++;
    }

    public void remove(E x) {
        if (isEmpty())
            throw new NoSuchElementException("Element " + x.toString() + " not found");

        // Removing front element
        if (first.data.equals(x)) {
            first = first.next;
            return;
        }

        Node<E> current = first;

        // Looping through until found
        while (current != null && !current.data.equals(x))
            current = current.next;

        // If null, not found
        if (current == null)
            throw new NoSuchElementException("Element " + x.toString() + " not found");

        // It has a next pointer, so not the last node.
        if (current.next != null)
            current.next.prev = current.prev;

        current.prev.next = current.next;

        size--;
    }

    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }

        Node<E> temp = first;

        first = temp.next;
        first.prev = null;
        temp.next = null;

        size--;

        return temp.data;
    }

    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }

        Node<E> temp = last;

        last = temp.prev;
        last.next = null;
        temp.prev = null;

        size--;

        return temp.data;
    }

    public E getFirst() {
        return first != null ? first.data : null;
    }

    public E getLast() {
        return last != null ? last.data : null;
    }

    public boolean contains(E value) {
        Node<E> current = first;
        while (current != null) {
            if (current.data.equals(value)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        Node<E> temp = first;
        StringBuilder builder = new StringBuilder("[");

        while (temp != null) {
            builder.append(temp.data).append(",");
            temp = temp.next;
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append("]");
        return builder.toString();
    }
}
