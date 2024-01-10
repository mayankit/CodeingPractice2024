package com.mayank.heap;

public class AbstractHeap<T> implements Heap<T>{

    private int size;
    private int actualSize;

    private T[] heap;
    public void add(T x) {

    }

    public void pop() {

    }

    public T peek() {
        return heap[1];
    }

    public int size() {
        return actualSize;
    }

}
