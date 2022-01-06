package myClass_05;

/**
 * @author shapemind
 * @create 2022-01-06 16:22
 */
public class Edge {
    public int weight;
    public Node from;
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
