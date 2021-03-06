package com.thinkingInJava.chapter17.container;

import com.thinkingInJava.util.Countries;

import java.util.*;

public class SlowMap<K,V> extends AbstractMap<K,V> {
    private List<K> keys=new ArrayList<K>();
    private List<V> values=new ArrayList<V>();
    public V put(K key,V value){
        V oldValue = get(key);//The old value or null
        if(!keys.contains(key)){
            keys.add(key);
            values.add(value);
        }else{
            values.set(keys.indexOf(key),value);
        }
        return oldValue;
    }

    //key is type object,not k
    public V get(Object key){
        if(!keys.contains(key)){
            return null;
        }
        return values.get(keys.indexOf(key));
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Map.Entry<K,V>> set = new HashSet<Map.Entry<K,V>>();
        Iterator<K> ki=keys.iterator();
        Iterator<V> vi=values.iterator();
        while(ki.hasNext()){
            set.add(new MapEntry<K,V>(ki.next(),vi.next()));
        }
        return set;
    }

    public static void main(String[] args){
        SlowMap<String,String> m = new SlowMap<String,String>();
        m.putAll(Countries.capitals(5));
        System.out.println(m);
        System.out.println(m.get("ANGOLA"));
        System.out.println(m.entrySet());
    }
}
