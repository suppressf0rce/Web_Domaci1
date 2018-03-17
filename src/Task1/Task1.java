package Task1;

import java.util.ArrayList;

public class Task1 {

    public static void main(String[] args) {
        read_write(100, 2);
    }

    private static void read_write(int k, int m){

        SyncedHashMap<Integer,Integer> mapa = new SyncedHashMap<>(20);

        ArrayList<Thread> threads = new ArrayList<>();

        for(int i = 0; i<k; i++){
            Integer test = i;
            Thread writeThread = new Thread(()->{
                if(!mapa.put(test, test)){
                    System.out.println("Mapa je puna!");
                }
            });
            threads.add(writeThread);
        }

        for(int i = 0; i<m; i++){
            Thread readThread = new Thread(()->{
                mapa.forEach((t,v) -> System.out.println("key: "+t+" value:"+v));
            });
            threads.add(readThread);
        }

        for(Thread thread: threads){
            thread.start();
        }

    }

}
