package myClass_03;

import basic_class_03.Code_06_RandomPool;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author shapemind
 * @create 2021-10-17 21:17
 */

/*
【题目】
设计一种结构，在该结构中有如下三个功能：
insert(key)：将某个key加入到该结构，做到不重复加入。
delete(key)：将原本在结构中的某个key移除。
getRandom()：等概率随机返回结构中的任何一个key。
【要求】
Insert、delete和getRandom方法的时间复杂度都是O(1)。

思路：
初始思路->创建两个map，一个以[元素,index]的entry形式加入；一个以[index,元素]的entry形式加入。当没有delete行为的时候，
只要利用Math.Rondam()(1 + index(最大值))即可以随机取到元素。但如果有delete行为的时候，上诉随机取index的方法就会失效。
因为存在部分index的元素为空的情况。

升级思路->当发生delete行为时候，把最后一个index的元素补上去，同时index的范围减1，再重新利用
Math.Rondam()(1 + index(最大值))随机取到元素
 */
public class MyCode_06_RandomPool {
    public static class Pool<K> {
        private HashMap<K, Integer> keyIndexMap;
        private HashMap<Integer, K> indexKeyMap;
        private int size;

        public Pool() {
            keyIndexMap = new HashMap<K, Integer>();
            indexKeyMap = new HashMap<Integer, K>();
            size = 0;
        }

        public void insert(K key) {
            if (!keyIndexMap.containsKey(key)) {
                keyIndexMap.put(key, size);
                indexKeyMap.put(size++, key);
            }
        }

        public void delete(K key) {
            if (keyIndexMap.containsKey(key)) {
                int deleteIndex = keyIndexMap.get(key);//获得要删除的key的下标
                int lastIndex = --size;//获得最后一个元素下标
                K lastKey = indexKeyMap.get(lastIndex);//获得最后一个元素的key
                indexKeyMap.put(deleteIndex, lastKey);//将最后一个元素替换掉被删掉的元素
                keyIndexMap.put(lastKey, deleteIndex);//keyIndexMap随即最后一个元素的value就进行更新
                keyIndexMap.remove(key);
                indexKeyMap.remove(lastIndex);
            } else {
                throw new IllegalArgumentException("The key is not found !");
            }
        }


        public K getRandom() {
            if (this.size == 0) {
                return null;
            }

            int randomIndex = (int)(Math.random() * size);
            return indexKeyMap.get(randomIndex);
        }
    }

    public static void main(String[] args) {
        Pool<String> pool = new Pool<String>();
        pool.insert("liang");
        pool.insert("jie");
        pool.insert("zu");
        pool.insert("1");
        pool.insert("2");
        pool.insert("3");

        HashMap<String, Integer> map = new HashMap<>();
        map.put("liang",0);
        map.put("jie",0);
        map.put("zu",0);
        map.put("1",0);
        map.put("2",0);
        map.put("3",0);

        for (int i = 0; i < 20000; i++) {
            String element = pool.getRandom();
            int countElement  = map.get(element) + 1;
            map.put(element, countElement);
        }

        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
            System.out.println("key = " + next.getKey() + ",value = " + next.getValue());
        }
        System.out.println("分隔符");
        pool.delete("2");

        map.put("liang",0);
        map.put("jie",0);
        map.put("zu",0);
        map.put("1",0);
        map.put("2",0);
        map.put("3",0);

        for (int i = 0; i < 20000; i++) {
            String element = pool.getRandom();
            map.put(element, map.get(element) + 1);
        }

        Iterator<Map.Entry<String, Integer>> entryIterator = map.entrySet().iterator();
        while(entryIterator.hasNext()) {
            Map.Entry<String, Integer> next = entryIterator.next();
            System.out.println("key = " + next.getKey() + ",value = " + next.getValue());
        }

    }
}
