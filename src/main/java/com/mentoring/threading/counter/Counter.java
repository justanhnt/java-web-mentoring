package com.mentoring.threading.counter;

public class Counter {
    public int count;

    static Counter instance;

    // simplified version of Singleton pattern
    public static synchronized Counter getInstance() {
        return instance == null ? instance = new Counter() : instance;
    }

    public synchronized void increment() {
        this.count ++;
    }

    public synchronized void decrement() {
        this.count --;
    }

    public synchronized int getValue() {
        return this.count;
    }
}
