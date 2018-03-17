package Task1;

import com.sun.istack.internal.NotNull;

import java.util.HashMap;
import java.util.function.BiConsumer;

public class SyncedHashMap<K, V> {

    private HashMap<K, V> hashMap;
    private int size;
    private boolean full;


    public SyncedHashMap(int size){
        hashMap = new HashMap<>();
        this.size = size;
    }

    public synchronized boolean put(K key,V value){

        if(full)
            return false;

            hashMap.put(key,value);
            if(hashMap.size() == size)
                full = true;

            return true;
    }

    public synchronized V remove(Object o){
            V ret = hashMap.remove(o);
            if(hashMap.size() == size)
                full = false;

            return ret;
    }

    public synchronized Object get(Object o){
        return hashMap.get(o);
    }

    public int size(){
        return hashMap.size();
    }

    public boolean containsKey(Object o){
        return hashMap.containsKey(o);
    }

    public boolean containsValue(Object o){
        return hashMap.containsValue(o);
    }

    public void clear(){
        synchronized (hashMap){
            hashMap.clear();
        }
    }

    public boolean isEmpty(){
        return hashMap.isEmpty();
    }

    public void forEach(@NotNull BiConsumer<K, V> consumer){
        hashMap.forEach(consumer);
    }

}
