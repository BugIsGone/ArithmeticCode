package myClass_05;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author shapemind
 * @create 2022-01-06 19:26
 *
 * 最小生成树：Prim算法
 * 思想：
 * 1.任选一个点出发；
 * 2.获得该点所有边，边进入集合（不去重）；
 * 3.从集合中取边权最小的边，然后判断下一个点是否新点；
 * 4.是新点，则去往下一个点，同时下一个点的边也加入到集合；不是新点，则删除该边，继续在集合里找最小值
 */
public class MyCode_06_Prim {
    public static class EdgeComparator implements Comparator<Edge> {

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    public static Set<Edge> primMST(Graph graph) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        HashSet<Node> set = new HashSet<>();
        HashSet<Edge> result = new HashSet<>();
        // foreach的作用是多个最小生成树，组成森林
        for (Node node: graph.nodes.values()) {
            if (!set.contains(node)) {
                set.add(node);
                // 根据边权值获得由边权组成小根堆
                for (Edge edge : node.edges) {
                    priorityQueue.add(edge);
                }
                while (!priorityQueue.isEmpty()) {
                    Edge edge = priorityQueue.poll();
                    Node toNode = edge.to;
                    if (!set.contains(toNode)) {
                        set.add(toNode);
                        result.add(edge);
                        // 把toNode的边加入到集合中
                        for (Edge nextEdge : node.edges) {
                            priorityQueue.add(nextEdge);
                        }
                    }
                }
            }
        }
        return null;
    }
}
