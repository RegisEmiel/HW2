package my_array_list;

import java.util.Arrays;
import java.util.Objects;

public class MyArrayList<E> {
    private static final int DEFAULT_CAPACITY = 1;

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    private int capacity;
    private int size;

    transient Object[] elementData;

    public MyArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
            capacity = initialCapacity;
        } else if (initialCapacity == 0) {
            this.elementData = new Objects[]{};
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    public boolean add(E value) {
        add(value, elementData, size);
        return true;
    }

    private void add(E e, Object[] elementData, int s) {
        if (s == elementData.length)
            elementData = grow(size + 1);
        elementData[s] = e;
        size = s + 1;
    }

    private Object[] grow(int minCapacity) {
        return elementData = Arrays.copyOf(elementData, newCapacity(minCapacity));
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();

        return (minCapacity > Integer.MAX_VALUE - 8) ? Integer.MAX_VALUE : Integer.MAX_VALUE - 8;
    }

    private int newCapacity(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);

        if (newCapacity - minCapacity <= 0) {
            if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA)
                return Math.max(DEFAULT_CAPACITY, minCapacity);
            if (minCapacity < 0) // overflow
                throw new OutOfMemoryError();

            return minCapacity;
        }

        return (newCapacity - Integer.MAX_VALUE - 8 <= 0)
                ? newCapacity
                : hugeCapacity(minCapacity);
    }

    public void trimToSize() {
        if (size < elementData.length) {
            elementData = (size == 0) ? new Objects[]{} : Arrays.copyOf(elementData, size);
        }
    }

    public E remove(int index) {
        Objects.checkIndex(index, size);

        E removedElement = (E) elementData[index];

        final int newSize;

        newSize = size - 1;

        if (newSize  > index)
            System.arraycopy(elementData, index + 1, elementData, index, newSize - index);

        size = newSize;

        elementData[size] = null;

        trimToSize();

        return removedElement;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elementData[i])) return i;
            }
        }
        return -1;
    }

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    public E get(int index) {
        Objects.checkIndex(index, size);
        return (E) elementData[index];
    }

    public E set(int index, E value) {
        Objects.checkIndex(index, size);
        E oldValue = (E) elementData[index];
        elementData[index] = value;

        return oldValue;
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "elementData=" + Arrays.toString(elementData) +
                '}';
    }
}

