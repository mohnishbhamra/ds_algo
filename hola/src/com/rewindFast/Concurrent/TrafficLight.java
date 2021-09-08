package com.rewindFast.Concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class TrafficLight {
    BlockingQueue<Integer> blockingQueue;
    char currentRoad;

    public TrafficLight() {
        blockingQueue = new LinkedBlockingQueue(1);
        System.out.println("capacity is "+blockingQueue.remainingCapacity());
        this.currentRoad = 'A';
    }

    public void carArrived(
            int carId,           // ID of the car
            int roadId,          // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
            int direction,       // Direction of the car
            Runnable turnGreen,  // Use turnGreen.run() to turn light to green on current road
            Runnable crossCar    // Use crossCar.run() to make car cross the intersection
    ) throws InterruptedException {
        blockingQueue.put(0);
        boolean needToChangeSignal = true;
        if (roadId == 1 || roadId == 2) {
            if (this.currentRoad == 'A') {
                needToChangeSignal = false;
            } else {
                this.currentRoad = 'A';
            }
        } else{
            if (this.currentRoad == 'B') {
                needToChangeSignal = false;
            } else {
                this.currentRoad = 'B';
            }
        }
        if (needToChangeSignal) {
            // blockingQueue.put(0);
            turnGreen.run();
            crossCar.run();
            // blockingQueue.take();
        } else {
            // blockingQueue.put(0);
            crossCar.run();
            // blockingQueue.take();
        }
        blockingQueue.take();
    }
}
