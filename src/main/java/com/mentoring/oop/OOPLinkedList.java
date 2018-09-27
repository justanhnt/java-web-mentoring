package com.mentoring.oop;

public class OOPLinkedList<T> implements OOPList<T> {

    int size;
    Node<T> head, tail;


    public OOPLinkedList() {
        this.size = 0;
        this.head = this.tail = null;
    }

    @Override
    public void add(T data) {
        linkTail(new Node<>(data));
        size ++;
    }

    @Override
    public void removeLast() {
        unlinkTail();
        size --;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void sort() {
        // Not implement yet
    }

    private void linkTail(Node<T> newNode) {
        if (this.tail != null) {
            this.tail.setNext(newNode);
            newNode.setPrev(this.tail);
            tail = newNode;
        } else {
            // in case tail is null; so does head is null too;
            this.head = this.tail = newNode;
            // both next and prev is null;
        }
    }

    private void unlinkTail() {
        if (this.tail == null) {
            throw new RuntimeException("The linked list doesn't have any element");
        } else {
            this.tail.getPrev().setNext(null);
            this.tail = this.tail.getPrev();
        }
    }
}
