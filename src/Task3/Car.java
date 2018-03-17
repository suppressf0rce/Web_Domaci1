package Task3;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class Car extends Thread {

    private Semaphore semaphore;

    public Car(Semaphore semaphore, String name){
        this.semaphore = semaphore;
        this.setName(name);
    }


    @Override
    public void run() {
        System.out.println("Car "+getName()+ " is driving");
        try {
            Thread.sleep(ThreadLocalRandom.current().nextLong(40000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Car "+getName()+ " is waiting for free station");
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Car "+getName()+ " is refilling the fuel");
        try {
            Thread.sleep(ThreadLocalRandom.current().nextLong(20000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Car driver "+getName()+ " is paying bills");
        try {
            Thread.sleep(ThreadLocalRandom.current().nextLong(20000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Car "+getName()+ " is leaving the station");
        semaphore.release();

    }
}
