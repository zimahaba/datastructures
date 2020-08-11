package edu.zimahaba.datastructures.linkedlist;

public class SinglyLinkedList {

    int size = 0;
    Node first;

    public void add(int value) {
        Node newNode = new Node(value);
        if (size == 0) {
            first = newNode;

        } else {

            // Iterates through nodes until the last one
            Node current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    /**
     * Adds a new element at a specified index.
     * If index is equals to size, adds the element at the end.
     * @param value
     * @param index
     */
    public void add(int value, int index) {
        if (index < 0 || index > size) {
            return;
        }

        Node prev = null;
        Node current = first;
        Node newNode = new Node(value);
        for (int i = 0; i <= size; i++) {
            if (i == index) {
                if (i == size) {
                    current = newNode;
                    prev.next = current;
                } else {
                    newNode.next = current;
                    if (prev == null) {
                        first = newNode;
                    } else {
                        prev.next = newNode;
                    }
                }
                break;
            }
            prev = current;
            current = current.next;
        }
        size++;
    }

    public void remove(int value) {
        remove(value, false);
    }

    public void removeAll(int value) {
        remove(value, true);
    }

    private void remove(int value, boolean all) {
        if (size > 0) {
            Node current = first;
            Node prev = null;

            for (int i = 0; i < size; i++) {
                if (current.value == value) {

                    if (i == 0) {
                        if (current.next == null) {
                            first = null;
                            break;
                        } else {
                            first = first.next;

                            if (!all) {
                                break;
                            }
                        }
                    } else {
                        prev.next = current.next;
                        break;
                    }

                }
                prev = current;
                current = current.next;
            }
            size--;
        }
    }

    public int get(int index) {
        int element = 0;
        if (size > 0) {
            Node current = first;
            for (int i = 0; i < size; i++) {
                if (i == index) {
                    element = current.value;
                    break;
                }
                current = current.next;
            }
        }
        return element;
    }

    public void reverse() {
        if (size > 1) {

            Node prev = null;
            Node current = first;
            Node next = null;

            while (current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }

            first = prev;
        }
    }

    public void print() {
        Node current = first;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
    }

    class Node {

        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
