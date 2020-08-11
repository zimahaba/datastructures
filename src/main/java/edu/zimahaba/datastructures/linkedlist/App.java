package edu.zimahaba.datastructures.linkedlist;

public class App {

    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.print();

        System.out.println("-------------");

        System.out.println(list.get(4));
    }

}
