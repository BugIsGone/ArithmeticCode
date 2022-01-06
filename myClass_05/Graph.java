package myClass_05;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author shapemind
 * @create 2022-01-06 16:47
 */
public class Graph {
    public HashMap<Integer, Node> nodes;
    public HashSet<Edge> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
