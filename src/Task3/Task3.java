package Task3;

import java.util.concurrent.Semaphore;

public class Task3 {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(2);

        Car carA = new Car(semaphore, "A");
        Car carB = new Car(semaphore, "B");
        Car carC = new Car(semaphore, "C");
        Car carD = new Car(semaphore, "D");
        Car carE = new Car(semaphore, "E");
        Car carF = new Car(semaphore, "F");


        carA.start();
        carB.start();
        carC.start();
        carD.start();
        carE.start();
        carF.start();


    }

}
