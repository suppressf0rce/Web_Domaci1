package Task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Task2 {

    private static List<Integer> result = Collections.synchronizedList(new ArrayList<>());


    public static void main(String[] args) {

        int n = 300000; // Range to test from 1
        int m = 1000; // Number of 10-s that each thread should calculate
        CyclicBarrier barrier = new CyclicBarrier(n/(m*10),printResults());

        for(int i = 0; i < n/(m*10); i++){
            Thread thread = new Thread(getPrimeCalculator(10*i*m+1, 10*i*m + m*10, barrier));
            thread.start();
        }
    }

    private static Runnable printResults(){
        return () -> result.forEach(System.out::println);
    }

    private static Runnable getPrimeCalculator(int start, int end, CyclicBarrier barrier){
        return ()->{
            for (int i = start; i <= end; i++) {
                if (isPrimeBruteForce(i))
                    result.add(i);
            }

            try {
                System.out.println("Finished!");
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        };
    }

    private static boolean isPrimeBruteForce(int number){
        for (int i = 2; i < number; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

}
