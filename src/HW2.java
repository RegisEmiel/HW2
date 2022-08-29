import my_array_list.MyArrayList;
import my_linked_list.MyLinkedList;

import java.util.ArrayList;
import java.util.LinkedList;

public class HW2 {
    public static void main(String[] args) {
        System.out.println("Задание 1");
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.addFirst(3);
        list.addLast(4);
        list.addLast(1);
        list.addFirst(5);
        list.addLast(2);
        System.out.println("Список: " + list.toString());

        list.addBefore(4, 9);
        list.addAfter(4, 10);

        System.out.println("Список после добавления элементов: " + list.toString());
        System.out.println("Список содержит 4: " + list.contains(4));

        list.remove(4);
        System.out.println("Список после удаления 4: " + list.toString());
        System.out.println("Список содержит 4: " + list.contains(4));

        System.out.println("Первый элемент: " + list.getFirst());
        System.out.println("Последний элемент: " + list.getLast());
        System.out.println("Список: " + list.toString());

        System.out.println("Извлечение первого элемента: " + list.removeFirst());
        System.out.println("Извлечение последнего элемента: " + list.removeLast());
        System.out.println("Список: " + list.toString());

        System.out.println();
        System.out.println("Задание 2");
        MyArrayList myArrayList = new MyArrayList<Integer>();
        myArrayList.add(5);
        myArrayList.add(7);
        myArrayList.add(4);
        System.out.println("Массив: " + myArrayList.toString());
        System.out.println("Индекс элемента 4: " + myArrayList.indexOf(4));
        myArrayList.remove(1);
        System.out.println("Массив после удаления элемента с индексом 1: " + myArrayList.toString());
        System.out.println("Массив содержит элемент 4: " + myArrayList.contains(4));
    }
}
