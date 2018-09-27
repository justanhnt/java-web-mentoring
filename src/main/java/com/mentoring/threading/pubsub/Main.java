package com.mentoring.threading.pubsub;

public class Main {
    public static void main(String[] args) {
        Buffer<Integer> buffer = Buffer.<Integer>getInstance();
        Thread pubThread = new Thread(new Publisher<Integer>(buffer));
        Thread subThread = new Thread(new Subscriber<Integer>(buffer));

        pubThread.start();
        subThread.start();
    }
}
