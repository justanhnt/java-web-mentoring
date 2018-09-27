package com.mentoring.threading.pubsub;

import java.util.Random;

public class Publisher <T>  implements Runnable {
    Buffer b;

    public Publisher(Buffer buffer) {
        this.b = buffer;
    }

    public void run() {
        while(true) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Integer data = new Random().nextInt(1000);
            System.out.println("Publishing " + data);
            b.blockingQueue.add(data);
        }
    }
}
