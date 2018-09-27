package com.mentoring.threading.pubsub;

public class Subscriber<T> implements Runnable{
    Buffer b;
    public Subscriber(Buffer buffer) {
        this.b = buffer;
    }

    public void run() {
        while (true) {
            if (b.blockingQueue.size() > 0) {
                Object data = b.blockingQueue.poll();
                System.out.println("Receiving  " + data);
            }
        }
    }
}

