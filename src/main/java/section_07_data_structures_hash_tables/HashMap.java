package section_07_data_structures_hash_tables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HashMap {
    public List<List<Object>>[] data;

    HashMap(int size) {
        data = new ArrayList[size];
    }

    public static void main(String[] args) {
        HashMap hashMap = new HashMap(2);

        hashMap.set("grapes", 12);
        hashMap.set("grapess", 33);

        System.out.println(Arrays.toString(hashMap.data));

        System.out.println(hashMap.get("grapesss"));
        System.out.println(hashMap.keys());
    }

    public int hash(String key) {
        int hash = 0;

        for (int i = 0; i < key.length(); i++) {
            hash = (hash + key.charAt(i) * i) % data.length;
        }

        return hash;
    }

    public void set(String key, int value) {
        var address = hash(key);
        if (data[address] == null) {
            data[address] = new ArrayList<List<Object>>();

        }

        var pairList = new ArrayList<Object>();
        pairList.add(key);
        pairList.add(value);

        data[address].add(pairList);
    }

    public Integer get(String key) {
        var address = hash(key);
        System.out.println(data[address]);

        var currentBucket = data[address];

        if (currentBucket != null) {
            for (var item : currentBucket) {
                if (item.get(0) == key) {
                    return (Integer) item.get(1);
                }
            }
        }

        return null;
    }

    public List<String> keys() {
        List<String> keys = new ArrayList<String>();


        for (List<List<Object>> bucket : data) {

            if (bucket != null) {
                for (List<Object> keyValuePair : bucket) {
                    keys.add(keyValuePair.get(0).toString());
                }
            }


        }

        return keys;


    }
}
