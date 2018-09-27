package com.mentoring.threading.pubsub;

import java.util.concurrent.ArrayBlockingQueue;

public class Buffer<T> {
    ArrayBlockingQueue<T> blockingQueue;

    static Buffer instance;

    public synchronized static <T> Buffer getInstance() {
        return instance == null ? instance = new Buffer<T>() : instance;
    }

    private Buffer() {
        this.blockingQueue = new ArrayBlockingQueue<>(10000);
    }


}
