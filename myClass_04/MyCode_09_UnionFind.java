package myClass_04;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @author shapemind
 * @create 2022-01-05 11:34
 * <p>
 * 并查集
 */
public class MyCode_09_UnionFind {
    public class Element<V> {
        public V value;

        public Element(V value) {
            this.value = value;
        }
    }

    // 并查集实现
    public class UnionFindSet<V> {
        public HashMap<V, Element<V>> elementMap;
        public HashMap<Element<V>, Element<V>> fatherMap;
        public HashMap<Element<V>, Integer> rankMap;

        public UnionFindSet(List<V> list) {
            elementMap = new HashMap<>();
            fatherMap = new HashMap<>();
            rankMap = new HashMap<>();
            for (V value : list) {
                Element<V> element = new Element<>(value);
                elementMap.put(value, element);
                fatherMap.put(element, element);
                rankMap.put(element, 1);
            }
        }
        // 打平每一个元素的父节点
        private Element<V> findHead(Element<V> element) {
            Stack<Element<V>> path = new Stack<>();
            // father是否为自身
            while (element != fatherMap.get(element)) {
                path.push(element);
                element = fatherMap.get(element);
            }
            while (!path.isEmpty()) {
                fatherMap.put(path.pop(), element);
            }
            return element;
        }

        // 是否为同一个集合中
        public boolean isSameSet(V a, V b) {
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                return findHead(elementMap.get(a)) == findHead(elementMap.get(b));
            }
            return false;
        }

        // 合并两个集合
        public void union (V a, V b) {
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                Element<V> aF = findHead(elementMap.get(a));
                Element<V> bF = findHead(elementMap.get(b));
                if (aF != bF) {
                    Element<V> big = rankMap.get(aF) >= rankMap.get(bF) ? aF : bF;
                    Element<V> small = big == aF ? bF : aF;
                    fatherMap.put(small, big);
                    rankMap.put(big, rankMap.get(aF) + rankMap.get(bF));
                    rankMap.remove(small);
                }
            }

        }


    }
}
